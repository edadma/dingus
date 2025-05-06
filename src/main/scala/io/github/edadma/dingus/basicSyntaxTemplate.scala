package io.github.edadma.dingus

val basicSyntaxTemplate =
  """# Markdown Basic Syntax
    |
    |## Headings
    |
    |# Heading 1
    |## Heading 2
    |### Heading 3
    |#### Heading 4
    |##### Heading 5
    |###### Heading 6
    |
    |## Paragraphs
    |
    |This is a paragraph. It's separated from other elements by a blank line.
    |
    |This is another paragraph. Markdown is easy to read and write!
    |
    |## Emphasis
    |
    |*This text is italicized*
    |
    |_This text is also italicized_
    |
    |**This text is bold**
    |
    |__This text is also bold__
    |
    |***This is bold and italicized***
    |
    |___This is also bold and italicized___
    |
    |## Lists
    |
    |### Unordered Lists
    |- Item 1
    |- Item 2
    |  - Nested item 1
    |  - Nested item 2
    |- Item 3
    |
    |### Ordered Lists
    |1. First item
    |2. Second item
    |   1. Nested item 1
    |   2. Nested item 2
    |3. Third item
    |
    |## Blockquotes
    |
    |> This is a blockquote
    |>
    |> It can span multiple lines
    |
    |## Horizontal Rules
    |
    |---
    |
    |***
    |
    |___
    |""".stripMargin
