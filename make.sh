#!/bin/sh
set -e

# Script inspired by https://gist.github.com/szeidner/613fe4652fc86f083cefa21879d5522b

readonly PROGNAME=$(basename $0)
readonly WORKING_DIR=$(cd -P -- "$(dirname -- "$0")" && pwd -P)

die() {
    echo "$PROGNAME: $*" >&2
    exit 1
}

usage() {
    if [ "$*" != "" ] ; then
        echo "Error: $*"
    fi

    cat << EOF
Usage: $PROGNAME --bundle-id [BUNDLE_ID_PRODUCTION] --bundle-id-staging [BUNDLE_ID_STAGING] --project-name [PROJECT_NAME]
Set up an iOS app from tuist template.
Options:
-h, --help                                   display this usage message and exit
-b, --bundle-id [BUNDLE_ID_PRODUCTION]       the production id (i.e. com.example.package)
-s, --bundle-id-staging [BUNDLE_ID_STAGING]  the staging id (i.e. com.example.package.staging)
-n, --project-name [PROJECT_NAME]            the project name (i.e. MyApp)
EOF
    exit 1
}

bundle_id_production=""
bundle_id_staging=""
project_name=""
minimum_ios_version=""

while [ $# -gt 0 ] ; do
    case "$1" in
    -h|--help)
        usage
        ;;
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

if [ -z "$bundle_id_production" ] ; then
    read -p "BUNDLE ID PRODUCTION (i.e. com.example.project):" bundle_id_production
fi

if [ -z "$bundle_id_staging" ] ; then
    read -p "BUNDLE ID STAGING (i.e. com.example.project.staging):" bundle_id_staging
fi

if [ -z "$bundle_id_production" ] || [ -z "$bundle_id_staging" ] ; then
    usage "Input cannot be blank."
fi

# Enforce package name
regex='^[a-z][a-z0-9_]*(\.[a-z0-9_-]+)+[0-9a-z_-]$'
if ! [[ $bundle_id_production =~ $regex ]]; then
    die "Invalid Package Name: $bundle_id_production (needs to follow standard pattern {com.example.package})"
fi

if [ -z "$project_name" ] ; then
    read -p "PROJECT NAME (i.e. NewProject):" project_name
fi

cd ios

# Because iOS-template is a submodule of the KKM-template, there is no .git directory.
sed -i.bak "/rm -f .git\/index/d" make.sh
sed -i.bak "s/minimum_version=\"\"/minimum_version=${minimum_ios_version}/g" make.sh
sed -i.bak "s/read -p \"iOS Minimum Version (i.e. 14.0):\" minimum_version/echo \"=> asdf\"/g" make.sh

sed -i.bak "/platform :ios*/d" podfile
sed -i.bak "1i\\"$'\n'"\
platform :ios, '${minimum_ios_version}'\\
" podfile


echo "=> Starting generate iOS project with iOS-template"

sh make.sh -b ${bundle_id_production} -s ${bundle_id_staging} -n ${project_name}

echo "=> Adding shared module to the podfile"

line_number=$(grep -n -i "# Development" podfile | cut -f1 -d:)

sed -i.bak "$(($line_number + 1))i\\"$'\n'"\
  pod 'shared', :path => '../shared'\\
" podfile
