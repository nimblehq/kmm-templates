# Welcome to the KMM Templates contributing guide <!-- omit in toc -->

Thank you for investing your time in contributing to our project! :sparkles:

## Getting started

### Git Submodules

- To add a submodule with default source branch (develop/main)
  ```
  $ git submodule add <repository> <path>
  ```
  For example,
  ```
  $ git submodule add git@github.com:nimblehq/android-templates.git android
  ```
- To add a submodule with a specific source branch
    ```
  $ git submodule add -b <branch> <repository> <path>
  ```
  For example,
  ```
  $ git submodule add -b feature/kmm-support-upgrade-to-gradle-8 git@github.com:nimblehq/android-templates.git android
  ```
- To remove a submodule
  ```
  $ git rm android
  ```
  Also, remove the cached repository of the submodule at `.git/modules/` if nescessary.
