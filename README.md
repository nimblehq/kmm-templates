# KMM Templates

Kotlin Multiplatform Mobile (KMM) template to set up all KMM projects at [Nimble](https://nimblehq.co/)

## Features

TODO

## Use the template

### Prerequisites

- [JDK](https://www.oracle.com/java/technologies/javase-downloads.html): Java 17
- [Android Studio](https://developer.android.com/studio) with [Kotlin Multiplatform Mobile plugin](https://kotlinlang.org/docs/multiplatform-mobile-plugin-releases.html)
- [Xcode](https://apps.apple.com/us/app/xcode/id497799835) 13.3+

Please check [this](https://kotlinlang.org/docs/multiplatform-mobile-setup.html#install-the-necessary-tools) out for more details.

### Set up a new project

Follow these steps to set up a new project from the template:

1. Clone or download this repository to your local machine.

2. Fetch all git sub-modules for the first time.

    `$ git submodule update --init --recursive`

3. Generate the new project by running the following command.

    `$ ./make.sh --bundle-id co.nimble.kmm.sample --bundle-id-staging co.nimble.kmm.sample.staging --project-name sample --ios-version 14.0`

The generated project is at `/sample` folder and ready to build, run and test 🎉

## License

This project is Copyright (c) 2014 and onwards Nimble. It is free software and may be redistributed under the terms specified in the [LICENSE] file.

[LICENSE]: /LICENSE

## About
<a href="https://nimblehq.co/">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="https://assets.nimblehq.co/logo/dark/logo-dark-text-160.png">
    <img alt="Nimble logo" src="https://assets.nimblehq.co/logo/light/logo-light-text-160.png">
  </picture>
</a>

This project is maintained and funded by Nimble.

We ❤️ open source and do our part in sharing our work with the community!
See [our other projects][community] or [hire our team][hire] to help build your product.

Want to join? [Check out our Jobs][jobs]!

[community]: https://github.com/nimblehq
[hire]: https://nimblehq.co/
[jobs]: https://jobs.nimblehq.co/
