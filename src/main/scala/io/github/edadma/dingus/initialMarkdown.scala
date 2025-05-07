package io.github.edadma.dingus

val initialMarkdown =
  """# Welcome to the Markdown Dingus :wave:
    |
    |This interactive playground demonstrates the capabilities of the `io.github.edadma.markdown` Scala library.
    |
    |## Basic Formatting
    |
    |You can write **bold text**, *italic text*, or even ***bold and italic text***.
    |Create ~~strikethrough~~ with two tildes.
    |
    |## Lists
    |
    |### Unordered Lists
    |- Item 1
    |- Item 2
    |  - Nested Item 2.1
    |  - Nested Item 2.2
    |- Item 3
    |
    |### Ordered Lists
    |1. First item
    |2. Second item
    |   1. Nested item 2.1
    |   2. Nested item 2.2
    |3. Third item
    |
    |## Code Examples
    |
    |Inline code: `console.log("Hello, world!")`
    |
    |```scala
    |def factorial(n: Int): Int =
    |  if (n <= 1) 1
    |  else n * factorial(n - 1)
    |```
    |
    |## Tables
    |
    || Feature | Supported | Example |
    ||---------|:---------:|---------|
    || Headers | ✅ | # Header |
    || Tables  | ✅ | This table |
    || Emojis  | ✅ | :rocket: |
    || Math    | ✅ | $E=mc^2$ |
    |
    |## Blockquotes
    |
    |> Markdown is a lightweight markup language that you can use to add formatting elements to plaintext text documents.
    |>
    |> — John Gruber
    |
    |## Math Expressions
    |
    |Inline math: $y = mx + b$
    |
    |Display math:
    |$$
    |\int_{a}^{b} f(x) \, dx = F(b) - F(a)
    |$$
    |
    |## Links and Images
    |
    |[GitHub Repository](https://github.com/edadma/markdown)
    |
    |![Sample Image](https://picsum.photos/200/100 "Random Image")
    |
    |## Emojis
    |
    |Express yourself with emojis like :smile:, :heart:, and :thumbsup:!
    |
    |## Try It Out!
    |
    |Choose a template from the dropdown menu to explore specific features, or edit this text to experiment with markdown formatting.
    |
    |Happy Markdown editing! :tada:""".stripMargin
