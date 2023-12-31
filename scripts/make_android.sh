#!/bin/sh
set -e

bundle_id=""
project_name=""

while [ $# -gt 0 ] ; do
    case "$1" in
    -b|--bundle-id)
        bundle_id="$2"
        shift
        ;;
    -n|--project-name)
        project_name="$2"
        shift
        ;;
    -*)
        usage "Unknown option '$1'"
        ;;
    *)
        usage "Too many arguments"
      ;;
    esac
    shift
done

echo "=> Starting generate Android project with android-templates"
cd android

# Clean up unnecessary stuff
sed -i '' "/        cleanNewProjectFolder()*/d" scripts/new_project.kts
sed -i '' "/        buildProjectAndRunTests()*/d" scripts/new_project.kts

kscript scripts/new_project.kts package-name=${bundle_id} app-name=${project_name} template=compose

# Convert bundle_id with dot to packake folder path, e.g., co.nimblehq.kmm.template -> co/nimblehq/kmm/template
package_path="${bundle_id//.//}"

# Correct dependencies
sed -i '' 's/Modules.DATA/Modules.SHARED/' $project_name/app/build.gradle.kts
sed -i '' "/implementation(project(Modules.DOMAIN))*/d" $project_name/app/build.gradle.kts
sed -i '' "/kover(project(Modules.DOMAIN))*/d" $project_name/app/build.gradle.kts

# Correct imports
sed -i '' 's/import '$bundle_id'.data.di.initKoin/import '$bundle_id'.di.initKoin/' $project_name/app/src/main/java/$package_path/MainApplication.kt

# Correct error mapping
sed -i '' 's/is ApiException -> error?.message/is ApiException -> message/' $project_name/app/src/main/java/$package_path/ui/ErrorMapping.kt

# Remove unnecessary definition of BASE_API_URL
sed -i '' "/buildConfigField(\"String\", \"BASE_API_URL\"*/d" $project_name/app/build.gradle.kts
sed -i '' "/import $bundle_id.BuildConfig*/d" $project_name/app/src/main/java/$package_path/di/modules/AppModule.kt
sed -i '' "/import $bundle_id.data.di.modules.BASE_API_URL*/d" $project_name/app/src/main/java/$package_path/di/modules/AppModule.kt
sed -i '' "/import org.koin.core.qualifier.named*/d" $project_name/app/src/main/java/$package_path/di/modules/AppModule.kt
sed -i '' "/    single(named(BASE_API_URL)) {\n*/d" $project_name/app/src/main/java/$package_path/di/modules/AppModule.kt
sed -i '' "/        BuildConfig.BASE_API_URL\n*/d" $project_name/app/src/main/java/$package_path/di/modules/AppModule.kt
sed -i '' "/    }\n*/d" $project_name/app/src/main/java/$package_path/di/modules/AppModule.kt

# Overwrite custom files
rsync -av ../custom/android/ $project_name/app/

# Overwrite the Kover config for KMM
perl -i -p0e 's/koverReport (.|\n)*}$/koverReport {\
    defaults {\
        mergeWith("stagingDebug")\
\
        val excludedFiles = listOf(\
            "io.mockative.*",\
            "*.BuildConfig",\
            "*.BuildKonfig",                        \/\/ BuildKonfig generated\
            "*.ComposableSingletons*",              \/\/ Jetpack Compose generated\
            "*.*\\\$*Preview\\\$*",                     \/\/ Jetpack Compose Preview functions\
            "*.di.*",                               \/\/ Koin\
            "*.ui.preview.*",                       \/\/ Jetpack Compose Preview providers\
            "*.*Test",                              \/\/ Test files\
            "*.*Test*",                             \/\/ Test cases\
            "*.*Mock",                              \/\/ mockative \@Mock generated\
            "*.test.*",                             \/\/ Test util package\
            "*.*\\\$\\\$serializer",                    \/\/ Kotlinx serializer\
        )\
        filters {\
            excludes {\
                classes(excludedFiles)\
            }\
        }\
    }\
}/g' $project_name/app/build.gradle.kts

cd ..
