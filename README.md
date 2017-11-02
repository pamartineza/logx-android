# Logx-Android
Clean Code Logx Kotlin implementation for Android with optional Crashlytics integration for repporting Non-Fatal exceptions.

If you are using a Clean Code project structure this library allows you to write logs not only from within your "android" code but also from your Domain, Usecases, Presenters, etc...

## Usage:
Init the library at your Application class or Main Activity as follows:

```kotlin
//Desired TAG
val logTag = "LOGX-DEMO"
//Enable logs only for DEBUG builds
val areLogsEnabled = BuildConfig.DEBUG
//init Logx object with AndroidLogs implementation
val androidLogs = AndroidLogs(areLogsEnabled, logTag)
Logx.setLogger(andoidLogs)
```
Writing logs:
```kotlin
//Logs for debug (d), warning (w), information (i), verbose (v), error(e)
Logx.d("This is a debug Log")
Logx.w("This is a warning Log")
Logx.i("This is an information Log")
Logx.v("This is a verbose Log")
Logx.e("This is an error Log")

//Error log with exception example
val e = MyException("My exception message)
Logx.e("This is an error log with an exception that will be sent to Crashlytics if available", e)

//Repports an exception to crashlytics if available
Logx.repportException("e")

//Override enabled status (for all variants)
val enabledStatusOverride = true
Logx.d(enabledStatusOverride, "This log will be printed even if logs are disabled")
```



## Gradle Dependency:
This libray is hosted in jitpack.io repository, add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}  
```
Add library implementation dependency and library interface contract in your App(android) module:

[![Release](https://jitpack.io/v/pamartineza/logx-android.svg)](https://jitpack.io/#pamartineza/logx-android)
```
dependencies {
  implementation "com.github.pamartineza:logx-android:x.y.z"
  implementation "com.github.pamartineza:logx:x.y.z"
}
```
Add library interface contract in your "pure" java/kotlin modules:

[![Release](https://jitpack.io/v/pamartineza/logx.svg)](https://jitpack.io/#pamartineza/logx)
```
dependencies {
  implementation "com.github.pamartineza:logx:x.y.z"
}
```

## Clean Code Logx interface contract
Logx interface contract code is available here -> https://github.com/pamartineza/logx
