package io.github.edadma.dingus

val smartPunctuationTemplate =
  """# Smart Punctuation
    |
    |When the `smartPunctuation` option is enabled, the parser transforms plain
    |ASCII punctuation into typographically-correct Unicode characters — the kind
    |of subtle polish you'd get from a professional typesetter.
    |
    |## Curly Quotes
    |
    |Straight quotes become curly quotes, contextually:
    |
    |- "Hello, world!" she said.
    |- 'It's a beautiful day,' he replied.
    |- She said, "It's 'magic', isn't it?"
    |
    |## Dashes
    |
    |Two hyphens become an en dash (for ranges); three become an em dash (for asides):
    |
    |- The meeting runs 9:00--10:30 in room 204.
    |- The new feature---long requested by our users---ships next week.
    |- Pages 42--57 cover the algorithm in detail.
    |
    |## Ellipsis
    |
    |Three dots become a proper ellipsis character:
    |
    |- Well... I suppose that could work.
    |- "To be or not to be..." he muttered.
    |
    |## In Context
    |
    |> "I can't believe it's already November---where did the year go?" she
    |> wondered. "It feels like just yesterday we were planning the summer
    |> release..."
    |""".stripMargin
