# Get the APK WITHOUT a powerful PC (free, ~15 minutes)

GitHub gives free cloud computers that build the APK for you.
You can do all of this from any browser — even your phone.

## One-time steps

1. Create a free account at github.com
2. Click **+** (top right) -> **New repository**
   - Name: `ali-bahi-assistant`
   - Keep it **Private**
   - Click **Create repository**
3. On the new repo page click **uploading an existing file**
4. Drag ALL files/folders from the extracted `ali-bahi-ai-assistant` folder
   into the upload box (including the hidden `.github` folder — on Windows,
   select everything inside the folder with Ctrl+A)
   - If the browser upload skips the `.github` folder: after the first upload,
     click **Add file -> Create new file**, type
     `.github/workflows/build-apk.yml` as the name, and paste the content of
     that file from this project.
5. Click **Commit changes**

## Getting your APK

1. Open the **Actions** tab of your repo
2. The "Build APK" run starts automatically (first build ~6-10 min)
3. When it shows a green check, click the run -> scroll to **Artifacts**
4. Download **AliBahi-APK** (a zip containing `app-debug.apk`)
5. Send the APK to your phone and install it

## Updates later

Edit any file on GitHub (or upload changed files) -> a fresh APK is built
automatically. Same Artifacts download.

If the build shows a red X, open the run, copy the error text and paste it
back to Claude — the fix is usually one or two lines.
