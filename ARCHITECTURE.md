# Architecture

```
WhatsApp notification
        │
        ▼
WaNotificationListener  (official Android NotificationListenerService)
  ├─ extracts sender + text (MessagingStyle aware, group detection)
  ├─ caches the chat's quick-reply action  → ReplyActionCache
  └─ MediaHandler (optional): voice → Vosk transcript, photo → llava description
        │
        ▼
ReplyPipeline (the brain)
  1. spam / duplicate / blacklist / cooldown / working-hours gates
  2. LanguageDetector (script analysis + Roman-Urdu/Punjabi word lists)
  3. Analysis: intent + sentiment (keyword heuristics, zero cost)
  4. FaqSearch: keyword-scored knowledge-base lookup (FIRST source of truth)
  5. Order lookup: order numbers in message, else by customer name
  6. PromptBuilder: business profile + Pakistani style rules + anti-hallucination
     rules + active persona + FAQ context + ORDER RECORD + learned style
     examples (few-shot) + recent history
  7. AiEngine (pluggable): GemmaEngine (on-device) | OllamaEngine (self-hosted)
     | null → FAQ-only fallback
  8. Confidence score → below threshold or approval mode → PendingReply queue
     → approval notification (✅/❌); otherwise auto-send
        │
        ▼
ReplyDispatcher → ReplyActionCache.send()   (RemoteInput into WhatsApp's own
                                             quick-reply PendingIntent)
```

## Design decisions
- **Notification method over protocol libraries**: only approach that is free,
  phone-native, and does not emulate WhatsApp internals (lowest ban risk).
- **Room + encrypted SharedPreferences**: all data local; settings AES-256.
- **Engine as an interface**: swap on-device ↔ self-hosted ↔ rules without
  touching the pipeline. Add new engines by implementing `AiEngine`.
- **FAQ before LLM**: deterministic answers for known questions; the LLM only
  fills gaps, always grounded by the FAQ + order record in its prompt.
- **Anti-hallucination**: prompt forbids invented facts; the confidence scorer
  penalizes long digit strings (fake tracking) when no order record exists;
  low confidence always routes to human approval.
- **Learning loop**: manual replies and edited approvals → StyleExample table →
  most-similar examples injected as few-shot into future prompts.

## Extending
- New engine (e.g. llama.cpp JNI): implement `AiEngine`, register in `EngineFactory`.
- New intents: add a line in `Analysis.intents`.
- New language: extend `LanguageDetector` word lists.
- Scheduled follow-ups: WorkManager is already a dependency — enqueue from `ReplyPipeline`.
