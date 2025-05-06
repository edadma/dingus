package io.github.edadma.dingus

val emojisTemplate =
  """# Emoji Extension Examples
    |
    |This document demonstrates the emoji extension support in Markdown. Emojis are specified using colon notation similar to GitHub.
    |
    |## Basic Emoji Syntax
    |
    |To include an emoji, wrap its name with colons:
    |
    |`:emoji_name:`
    |
    |For example, `:smile:` renders as :smile:
    |
    |## Common Emoji Examples
    |
    |### Faces and People
    |
    |- `:smile:` → :smile:
    |- `:laughing:` → :laughing:
    |- `:blush:` → :blush:
    |- `:heart_eyes:` → :heart_eyes:
    |- `:thinking:` → :thinking:
    |- `:confused:` → :confused:
    |
    |### Nature and Animals
    |
    |- `:sunny:` → :sunny:
    |- `:umbrella:` → :umbrella:
    |- `:dog:` → :dog:
    |- `:cat:` → :cat:
    |- `:turtle:` → :turtle:
    |- `:tropical_fish:` → :tropical_fish:
    |
    |### Objects and Symbols
    |
    |- `:heart:` → :heart:
    |- `:sparkles:` → :sparkles:
    |- `:star:` → :star:
    |- `:zap:` → :zap:
    |- `:warning:` → :warning:
    |- `:lock:` → :lock:
    |
    |### Foods and Activities
    |
    |- `:pizza:` → :pizza:
    |- `:coffee:` → :coffee:
    |- `:soccer:` → :soccer:
    |- `:musical_note:` → :musical_note:
    |- `:tada:` → :tada:
    |- `:gift:` → :gift:
    |
    |## Emojis in Text
    |
    |You can include emojis anywhere in your text! For example:
    |
    |I :heart: Markdown! It's :100: awesome.
    |
    |The :cat: jumped over the :dog:.
    |
    |## Invalid Emoji Examples
    |
    |These examples will not render as emojis:
    |
    |- `: smile:` (space after first colon)
    |- `:smile :` (space before second colon)
    |- `:not_a_real_emoji:` (not in GitHub emoji list)
    |- `:SMILE:` (case sensitive)
    |
    |## Emoji Aliases
    |
    |Some emojis have multiple names or aliases:
    |
    |- `:smile:` and `:smiley:` may render the same emoji
    |- `:+1:` and `:thumbsup:` are aliases for 👍
    |
    |## Tips for Emoji Usage
    |
    |- Emojis can make your documentation more engaging :rocket:
    |- Don't overuse emojis as they can become distracting
    |- Use relevant emojis to emphasize important points :bulb:
    |- Emoji support may vary between different Markdown processors
    |
    |## References
    |
    |This implementation supports the same emoji names as GitHub. See the [GitHub Emoji Cheat Sheet](https://github.com/ikatyang/emoji-cheat-sheet) for a complete list.
    |""".stripMargin
