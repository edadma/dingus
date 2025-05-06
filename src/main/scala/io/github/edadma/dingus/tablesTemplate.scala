package io.github.edadma.dingus

val tablesTemplate =
  """# Markdown Tables
    |
    |## Basic Table
    |
    || Name     | Type   | Description         |
    ||----------|--------|---------------------|
    || id       | Int    | Unique identifier   |
    || title    | String | Post title          |
    || content  | String | Post content        |
    || authorId | Int    | Author identifier   |
    |
    |## Aligned Table
    |
    || Left Aligned | Center Aligned | Right Aligned |
    ||:-------------|:--------------:|-------------:|
    || Left         | Center         | Right        |
    || Text         | Text           | Text         |
    |
    |## Compact Table
    |
    || Function | Description                    |
    ||----------|--------------------------------|
    ||map()     |Transforms elements             |
    ||filter()  |Selects elements by predicate   |
    ||reduce()  |Combines elements               |
    ||forEach() |Executes function on elements   |
    |""".stripMargin
