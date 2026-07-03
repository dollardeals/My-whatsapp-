# Fully Offline Setup

Goal: the assistant works with the internet OFF (except WhatsApp itself, which
obviously needs data to receive messages).

What is already offline:
- Message capture & sending (Android notification system — local)
- Database, FAQs, orders, learning, analytics (Room/SQLite — local)
- Language / intent / sentiment / spam detection (pure Kotlin — local)
- FAQ-only reply mode — fully offline

To make the AI offline too:
1. One-time download of the Gemma 3n model file (~3.1 GB) — do this once on Wi-Fi
2. Settings → AI Engine → On-device Gemma → point to the file
3. Voice: one-time download of a Vosk model (~45 MB)

After these one-time downloads, airplane-test it: turn off Wi-Fi/data,
open the app, use Chats → AI draft on an old message — generation still works.

The Ollama option needs your local network (not the internet) — traffic goes
phone → your PC over Wi-Fi only. No data ever leaves your home.

Privacy checklist:
- INTERNET permission is used ONLY for the optional Ollama/vision calls
- No analytics SDK, no crash reporting, no third-party tracking of any kind
- Settings encrypted with AES-256 (Android Keystore)
- Backups are files YOU create and store where you choose
