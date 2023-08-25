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

# Correct dependencies
sed -i '' 's/Modules.DATA/Modules.SHARED/' sample/app/build.gradle.kts
sed -i '' "/implementation(project(Modules.DOMAIN))*/d" sample/app/build.gradle.kts
sed -i '' "/kover(project(Modules.DOMAIN))*/d" sample/app/build.gradle.kts

cd ..
