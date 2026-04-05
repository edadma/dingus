package io.github.edadma.dingus

val docTagsTemplate =
  """# API Doc Tags
    |
    |The `docTags` extension parses `@name [target] — body` block-level annotations,
    |intended as building blocks for documentation generators, linters, and
    |indexers built on top of the markdown AST.
    |
    |Tags are configured via a `TagRegistry` — the processor only parses the
    |syntax; downstream tools decide what each tag means.
    |
    |## Function Documentation
    |
    |A typical use case is documenting a function's signature:
    |
    |@api reports a fatal error and terminates the process
    |
    |@param msg — human-readable description of the failure
    |
    |@param code — the exit code to pass to the OS
    |
    |@returns never returns
    |
    |## Target vs. No Target
    |
    |Tags can be configured per-tag. Some tags take an **identifier target** after
    |the name (like `@param msg`), while others don't:
    |
    |@api with no target — everything after the name is the body
    |
    |@param name — takes an identifier target, then separator, then body
    |
    |@since 0.4.0
    |
    |## Content Modes
    |
    |Each tag's body can be parsed in one of three modes:
    |
    |@example
    |    // Block mode supports nested markdown structure:
    |    // - fenced code blocks
    |    // - lists
    |    // - paragraphs
    |
    |@returns a value with **inline formatting** support, including `code` and [links](https://example.com)
    |
    |@literal in opaque mode, **markdown** is NOT parsed — everything stays as-is
    |
    |## Why Use Doc Tags?
    |
    |- Generate API reference pages automatically from source comments
    |- Validate `@param` names against actual function signatures
    |- Build cross-reference links between tags and code declarations
    |- Lint for missing or inconsistent documentation
    |""".stripMargin
