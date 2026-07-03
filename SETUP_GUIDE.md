# Setup Guide (step by step, no coding needed after install)

## 1. Install the app
Install `app-release.apk` on your Android phone (Android 8.0+).
When Android warns about unknown apps, allow install from your file manager.

## 2. Connect to WhatsApp (30 seconds)
1. Open **Ali Bahi AI Assistant**
2. On the Dashboard the status card says "Not connected" → tap **Enable**
3. In the system list, turn ON **Ali Bahi AI Assistant** → Allow
4. Also allow the app to show notifications (for approval alerts)

Done. Every new WhatsApp message now flows through the assistant.

## 3. First test
From another phone send: `Assalam o Alaikum, rug ka price kya hai?`
Within seconds you get a notification: **Reply ready for <name>** with
✅ Send / ❌ Reject. Tap Send. The customer receives the reply from your number.

## 4. Choose your AI brain (Settings → AI Engine)

### Option A — FAQ only (works immediately, default)
No downloads. Answers come from your FAQ knowledge base. Great for common
questions (COD, delivery time, return policy).

### Option B — On-device Gemma 3n (private, offline)
1. On the phone, download the free model **gemma-3n-E2B-it-int4.task** (~3.1 GB)
   from huggingface.co/google/gemma-3n-E2B-it-litert-preview (free account, accept license)
2. Put it in your **Download** folder
3. Settings → AI Engine → *On-device Gemma* → enter the file path, e.g.
   `/storage/emulated/0/Download/gemma-3n-E2B-it-int4.task`
Notes: needs ~4 GB free RAM. Replies take 5–20 s on a mid-range phone.
Battery-friendly options (small context, one generation at a time) are built in.

### Option C — Your own PC with Ollama (best quality, still free)
On any PC (Windows/Mac/Linux) on the same Wi-Fi:
```
1. Install Ollama from ollama.com (free)
2. ollama pull qwen2.5:7b          # best free Urdu/Roman-Urdu/Hindi model
3. (optional, for photos) ollama pull llava:7b
4. Windows: setx OLLAMA_HOST 0.0.0.0   then restart Ollama
5. Find the PC's IP:  ipconfig  → e.g. 192.168.1.100
```
In the app: Settings → AI Engine → *My own Ollama server* →
URL `http://192.168.1.100:11434`, model `qwen2.5:7b`.

## 5. Voice notes (optional)
1. Download a free Vosk model, e.g. **vosk-model-small-hi-0.22** (~45 MB, works
   for Hindi/Urdu speech) from alphacephei.com/vosk/models
2. Unzip so the model files land in the folder shown in Settings → Voice notes
   (usually `Android/data/com.homeessential.alibahi/files/vosk-model/`)
3. Grant "All files access" when asked (needed to read WhatsApp voice files)
4. Turn ON Settings → Voice notes

## 6. Photos (optional)
Requires Option C (Ollama) + `ollama pull llava:7b` → turn ON Settings → Images.

## 7. Daily use
- **Approve tab**: pending drafts. Edit before sending — every edit teaches the AI your style.
- **Brain tab**: FAQs, AI personas, Orders & tracking, knowledge files, analytics.
- **Orders**: add tracking numbers here — the AI will quote them automatically and will NEVER invent one.
- When you trust the replies: Dashboard → turn OFF Approval Mode (or keep the confidence threshold so weak replies still ask you first).
