#!/bin/sh
set -e

bundle_id_production=""
bundle_id_staging=""
project_name=""
minimum_ios_version=""

while [ $# -gt 0 ] ; do
    case "$1" in
    -b|--bundle-id)
        bundle_id_production="$2"
        shift
        ;;
    -s|--bundle-id-staging)
        bundle_id_staging="$2"
        shift
        ;;
    -n|--project-name)
        project_name="$2"
        shift
        ;;
    -iv|--ios-version)
        minimum_ios_version="$2"
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

cd ios

echo "=> Removing unnecessary files and folders"
rm -rf {PROJECT_NAME}/sources/data

# Because iOS-template is a submodule of the KKM-template, there is no .git directory.
sed -i '' "/rm -f .git*/d" make.sh

sed -i '' "s/minimum_version=\"\"/minimum_version=${minimum_ios_version}/g" make.sh
sed -i '' "s/read -p \"iOS Minimum Version (i.e. 14.0):\" minimum_version/echo \"=> Minimum iOS version: $minimum_ios_version\"/g" make.sh

sed -i '' "/platform :ios*/d" podfile
sed -i '' "/pod 'RxAlamofire'*/d" podfile
sed -i '' "1i\\"$'\n'"\
platform :ios, '${minimum_ios_version}'\\
" podfile


echo "=> Starting generate iOS project with iOS-template"

sh make.sh -b ${bundle_id_production} -s ${bundle_id_staging} -n ${project_name}

echo "=> Adding shared module to the podfile"

line_number=$(grep -n -i "# Development" podfile | cut -f1 -d:)

sed -i '' "$(($line_number + 1))i\\"$'\n'"\
  pod 'shared', :path => '../shared'\\
" podfile

echo "=> Remove unnecessary files after generating the iOS module"
rm -rf .github
rm -f README.md
rm -f LICENSE
rm -f bitrise.yml
rm -f codemagic.yaml
rm *.sh

cd ..
