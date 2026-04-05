package io.github.edadma.dingus

val footnotesTemplate =
  """# Footnotes
    |
    |Markdown supports footnotes via the `[^label]` syntax — a compact way to add
    |asides without breaking the flow of your prose[^1]. Footnotes are numbered
    |automatically in the order they are *first referenced*, not in the order they
    |are defined[^ordering].
    |
    |## Basic Usage
    |
    |You can reference the same footnote multiple times[^1]. Labels may be numeric
    |(`[^1]`) or descriptive (`[^note]`, `[^caveat]`) — descriptive labels are
    |easier to maintain when you reorder paragraphs[^descriptive].
    |
    |## Rich Content
    |
    |Footnote bodies are fully parsed markdown: **bold**, *italic*, `code`, and
    |even [links](https://commonmark.org) all work[^rich]. Multi-paragraph
    |footnotes are also supported[^multi].
    |
    |[^1]: This is a footnote. The backref arrow ↩ takes you back to the reference.
    |
    |[^ordering]: The footnote section at the bottom of the document orders entries
    |    by first-reference order, so renumbering is automatic when you reorganize.
    |
    |[^descriptive]: Numeric labels require renumbering when you add a new one in
    |    the middle; descriptive labels don't.
    |
    |[^rich]: For example, this footnote has **bold text** and a `code span`.
    |
    |[^multi]: This is the first paragraph of a multi-paragraph footnote.
    |
    |    And this is the second paragraph — continuation lines must be indented
    |    by four spaces.
    |""".stripMargin
