package io.github.edadma.dingus

val attributesTemplate =
  """# Attributes {#top .page-title}
    |
    |The `attributes` extension lets you attach HTML attributes directly to
    |headings, fenced code blocks, and images using a compact `{...}` syntax.
    |
    |## Syntax {#syntax-section}
    |
    |Inside the braces, you can specify:
    |
    |- `#id` — a single id
    |- `.class` — any number of classes
    |- `key=value` or `key="quoted value"` — arbitrary key-value pairs
    |
    |## Headings with Attributes
    |
    |### A Highlighted Heading {.highlight .featured}
    |
    |### Heading with an ID and Data Attribute {#custom-anchor data-level="3"}
    |
    |#### Multiple Classes {.a .b .c}
    |
    |## Fenced Code Blocks
    |
    |Attach attributes to fenced code blocks after the language:
    |
    |```scala {#example1 .executable data-lang="scala"}
    |def greet(name: String): String =
    |  s"Hello, $name!"
    |
    |println(greet("world"))
    |```
    |
    |## Images
    |
    |Attributes can follow an image directly:
    |
    |![A scenic photo](https://picsum.photos/400/200){#hero .responsive .rounded}
    |
    |## When to Use
    |
    |Attributes are useful for:
    |
    |- Creating stable anchor links to headings (`{#introduction}`)
    |- Adding CSS classes without raw HTML
    |- Tagging elements for post-processing or styling
    |""".stripMargin
