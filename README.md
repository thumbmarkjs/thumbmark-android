<p align="center"><img width="100" src="https://avatars.githubusercontent.com/u/157797798"></p>

# Thumbmark Android 

Thumbmark is the world's second best browser fingerprinting library. While not (yet?) as good, it's a free open source alternative to the market leading FingerprintJS. It is easy to use and easily extendable.

Thumbmark is open source (MIT).

🙏 Please don't do evil. Thumbmark is meant to be used for good. Use this to prevent scammers and spammers for example. If you see this library being used for evil, please raise an issue in this repo.

## Installation

### Jitpack

[JitPack](https://jitpack.io/) is an easy to use package repository for Git. It allows for publishing JVM and Android libraries. You'll need to add the following to your `settings.gradle` file in order to use JitPack dependencies:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

Once you have added JitPack to your project, you can import this library by adding the following to your apps `build.gradle` file:

```kotlin
dependencies {
    implementation 'com.github.thumbmarkjs:thumbmark-android:0.1.+'
}
```
## Usage
The SDK provides a singleton by way of `Thumbmark.kt` This singleton provides two main values; A string identifier and a `Fingerprint` object. 

### Device identifier
Device identifiers are hashed, this means that they can not be converted back to a fingerprint. You can obtain a, SHA256 hashed, device identifier with the following:

```kotlin
import com.thumbmarkjs.thumbmark_android.Thumbmark

val id: String = Thumbmark.id(context = this)
```

If you have alternative hashing requirements, you can pass in your own hasher as follows (in the example below we're using `SHA-1` however the function takes any `String` value consumable by `MessageDigest`):

```kotlin
import com.thumbmarkjs.thumbmark_android.Thumbmark

let identifier: String? = Thumbmark.id("SHA-1", this)
```

### Device fingerprint
A device fingerprint is a strongly typed object, consisting of known hardware and software parameters/configurations/settings. You can obtain the device fingerprint as follows:

```kotlin
import com.thumbmarkjs.thumbmark_android.Thumbmark

val fingerprint: Fingerprint = Thumbmark.fingerprint(this)
```

## Requirements

- Minimum SDK Version 21
- Compile SDK Version 34

## Communication

- If you need **help with a Thumbmark feature**, open an issue here on GitHub and follow the guide. The more detail the better!
- If you'd like to **discuss Thumbmark best practices**, open an issue here on GitHub and follow the guide. The more detail the better!
- If you'd like to **discuss a feature request**, open an issue here on GitHub and follow the guide. The more detail the better!
- If you believe you've **found a bug**, open an issue here on GitHub and follow the guide. The more detail the better!
- If you **want to contribute**, submit a pull request!


## Sponsors

### <img height="50" src="https://3432867.fs1.hubspotusercontent-na1.net/hubfs/3432867/_01.Branding/Ordermentum_Logo_Legacy%20Orange-1.png">
ThumbmarkAndroid has been developed with 🧡 by [Ordermentum](https://ordermentum.com). A huge thanks goes to them for donating their development efforts to bring ThumbmarkJS to the open source mobile community. 



## License

ThumbarkAndroid is released under the MIT license. [See LICENSE](https://github.com/thumbmarkjs/thumbmark-android/blob/main/LICENSE) for details.
