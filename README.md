# Ali Bahi AI Assistant 🤖🇵🇰

A **100% free, open-source Android app** that automatically replies to your business
WhatsApp messages with natural, Pakistani-style responses — in **English, Urdu,
Roman Urdu, Hindi, Punjabi and mixed language**.

Built for **Home Essential** (rugs, mats, pillows, home decor) but every FAQ,
prompt and setting is editable in the app.

---

## Why this architecture (research summary)

| Option | Verdict |
|---|---|
| Baileys / whatsapp-web.js (protocol emulation) | ❌ Real account-ban risk (Meta increased detection of unofficial APIs in 2025–26); needs Node.js/Chromium — impractical on a phone |
| Official WhatsApp Business API | ❌ Paid (BSP required) |
| **Android Notification Listener + Quick Reply** ✅ | Uses Android's *official* notification-reply system (same method as the open-source app Watomatic). No protocol hacking, no linked device, lowest ban risk, fully free, runs on your phone |

**AI is modular** — pick in Settings:
1. **FAQ-only mode** (default) — instant, no model needed, answers from your knowledge base
2. **On-device Gemma 3n** (MediaPipe) — private, offline; fits 6–12 GB RAM phones
3. **Self-hosted Ollama server** — best quality (qwen2.5:7b — currently the strongest free model for Urdu/Hindi); your PC, your data, zero fees

Voice notes are transcribed **offline with Vosk**. Photos are described by a free
**llava** vision model on your Ollama server. Files (PDF/Word/Excel/TXT) become
extra AI knowledge — parsed locally.

## Features

- Auto-reply with language detection (en / ur / roman-ur / hi / pa / mixed) — replies in the same language
- Pakistani business tone: Assalam-o-Alaikum, Ji Sir, Bilkul, InshaAllah, Shukriya, Allah Hafiz
- **Approval mode (default ON):** every AI draft comes to you with ✅ Send / ❌ Reject buttons; edits teach the AI your style
- Editable **FAQ knowledge base** (questions, answers, keywords, categories) — searched **before** the AI generates
- **Orders & tracking database** — the AI can *only* quote tracking numbers stored here (never invents them)
- **Learning system** — every manual reply is saved and used as a style example in future prompts
- Unlimited **custom AI personas** (Support, Sales, Returns, Short replies, Friendly…)
- Sentiment analysis (angry → apologize first), intent detection, spam + duplicate detection
- Working hours + away message, greeting message, typing delay, per-chat cooldown, blacklist/whitelist
- Customer labels + notes, conversation search, AI confidence score
- Dashboard, live chats, analytics, dark/light mode
- Export chats (JSON), database backup/restore
- **Privacy:** everything stays on your phone; settings encrypted (AES-256); zero cloud, zero tracking, zero subscriptions

## Quick start

1. Build the APK (see `docs/BUILD_APK.md`) or open the project in Android Studio → Run
2. Install on your phone, open the app
3. Dashboard → **Enable** notification access (this is the WhatsApp connection)
4. Allow notifications when asked
5. Send yourself a test message from another phone → a draft appears in **Approve**
6. Edit FAQs, orders, and personas under **Brain**

That's it — no QR codes, no linked devices, no servers required.

## Honest limitations (read this)

The safe notification method has trade-offs:
- Replies are only possible **while a chat has an active WhatsApp notification** (if you open WhatsApp and read the message, the reply channel for that chat closes until they message again)
- The app **cannot send images/files**, only text
- It cannot see messages you type inside WhatsApp itself — the learning system learns from replies you send **through this app**
- Media content (voice/photo) requires the optional "All files access" permission

No unofficial WhatsApp automation is 100% risk-free. This method is the lowest-risk
free option because it only uses Android's official APIs, but use sensible settings
(typing delay, cooldown, approval mode) — they are ON by default.

## Project layout

```
app/src/main/java/com/homeessential/alibahi/
├── App.kt                  # service locator (db, settings, pipeline)
├── data/                   # Room database, encrypted settings, seed data
├── ai/                     # language detection, intent/sentiment, FAQ search,
│                           # prompt builder, Gemma & Ollama engines, ReplyPipeline
├── wa/                     # notification listener, reply cache, dispatcher, approvals
├── media/                  # Vosk voice transcription, Ollama vision
├── knowledge/              # PDF/Word/Excel/TXT ingestion
├── util/                   # backup / restore / export
└── ui/                     # Jetpack Compose admin panel (9 screens)
```

See `docs/` for setup, architecture, offline guide and build instructions.

## License / cost

All components are free and open-source friendly: Kotlin, Jetpack Compose, Room,
MediaPipe (Apache-2.0), Vosk (Apache-2.0), pdfbox-android (Apache-2.0),
OkHttp (Apache-2.0), Ollama (MIT), Gemma/Qwen models (free weights).
**Total running cost: Rs. 0/month.**
