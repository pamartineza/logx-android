# Logx-Android
Clean Code Logx Kotlin implementation for Android with optional Crashlytics integration for repporting Non-Fatal exceptions

If you are using a Clean Code project structure this library allows you to write logs not only from your "android" code but also from your Domain, Usecases, Presenters, etc...

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
Add library dependency in your module:
```
dependencies {
  implementation "com.github.pamartineza:logx-android:1.0.0"
}
```

## Clean Code Logx interface contract
Logx interface contract is available here -> https://github.com/pamartineza/logx
