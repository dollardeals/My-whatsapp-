# Building the APK (one time, on any free PC)

## Easiest: Android Studio (free)
1. Install Android Studio from developer.android.com/studio
2. Open this project folder ("Open an Existing Project")
3. Let Gradle sync (first time downloads dependencies, ~5 min)
4. Debug APK: **Build → Build App Bundle(s)/APK(s) → Build APK(s)**
   → APK at `app/build/outputs/apk/debug/app-debug.apk`
5. Release APK (recommended):
   **Build → Generate Signed App Bundle/APK → APK → Create new keystore**
   (any password; keep the file to sign future updates)
   → APK at `app/build/outputs/apk/release/app-release.apk`
6. Copy the APK to your phone and install.

## Command line alternative
```
# needs JDK 17 + Android SDK (ANDROID_HOME set)
gradle wrapper          # generates gradlew if missing
./gradlew assembleDebug
```

## Updates
Change code → rebuild with the SAME keystore → install over the old app
(data and settings are preserved).

## Requirements file
Android dependencies are declared in `app/build.gradle.kts` (the Android
equivalent of requirements.txt). No other installation is needed.
