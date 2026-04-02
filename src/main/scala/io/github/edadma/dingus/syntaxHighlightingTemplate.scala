package io.github.edadma.dingus

val syntaxHighlightingTemplate =
  """# Syntax Highlighting
    |
    |Fenced code blocks are automatically highlighted when a language is specified.
    |
    |## Scala
    |
    |```scala
    |case class User(name: String, age: Int)
    |
    |def greet(user: User): String =
    |  val message = s"Hello, ${user.name}!"
    |  if user.age >= 18 then message
    |  else s"$message (minor)"
    |
    |val users = List(User("Alice", 30), User("Bob", 12))
    |users.map(greet).foreach(println)
    |```
    |
    |## JavaScript
    |
    |```javascript
    |async function fetchUsers() {
    |  const response = await fetch("/api/users");
    |  const users = await response.json();
    |
    |  return users.filter(u => u.active)
    |    .map(u => ({ ...u, displayName: `${u.first} ${u.last}` }));
    |}
    |
    |// Arrow function with destructuring
    |const greet = ({ name, age }) => {
    |  if (age >= 18) {
    |    console.log(`Welcome, ${name}!`);
    |  }
    |};
    |```
    |
    |## TypeScript
    |
    |```typescript
    |interface Config {
    |  readonly host: string;
    |  port: number;
    |  debug?: boolean;
    |}
    |
    |type Result<T> = { ok: true; value: T } | { ok: false; error: string };
    |
    |async function connect(config: Config): Promise<Result<void>> {
    |  try {
    |    await fetch(`https://${config.host}:${config.port}`);
    |    return { ok: true, value: undefined };
    |  } catch (e) {
    |    return { ok: false, error: String(e) };
    |  }
    |}
    |```
    |
    |## Python
    |
    |```python
    |from dataclasses import dataclass
    |from typing import Optional
    |
    |@dataclass
    |class Point:
    |    x: float
    |    y: float
    |    label: Optional[str] = None
    |
    |def distance(a: Point, b: Point) -> float:
    |    '''Calculate Euclidean distance between two points.'''
    |    return ((a.x - b.x) ** 2 + (a.y - b.y) ** 2) ** 0.5
    |
    |points = [Point(0, 0, "origin"), Point(3, 4)]
    |print(f"Distance: {distance(*points):.2f}")
    |```
    |
    |## Rust
    |
    |```rust
    |use std::collections::HashMap;
    |
    |fn word_count(text: &str) -> HashMap<&str, usize> {
    |    let mut counts = HashMap::new();
    |    for word in text.split_whitespace() {
    |        *counts.entry(word).or_insert(0) += 1;
    |    }
    |    counts
    |}
    |
    |fn main() {
    |    let text = "hello world hello rust";
    |    let counts = word_count(text);
    |    println!("{:?}", counts); // {"hello": 2, "world": 1, "rust": 1}
    |}
    |```
    |
    |## Go
    |
    |```go
    |package main
    |
    |import "fmt"
    |
    |type Server struct {
    |    Host string
    |    Port int
    |}
    |
    |func (s *Server) Start() error {
    |    addr := fmt.Sprintf("%s:%d", s.Host, s.Port)
    |    fmt.Printf("Listening on %s\n", addr)
    |    return nil
    |}
    |
    |func main() {
    |    srv := &Server{Host: "localhost", Port: 8080}
    |    if err := srv.Start(); err != nil {
    |        panic(err)
    |    }
    |}
    |```
    |
    |## SQL
    |
    |```sql
    |SELECT u.name, COUNT(o.id) AS order_count, SUM(o.total) AS total_spent
    |FROM users u
    |LEFT JOIN orders o ON o.user_id = u.id
    |WHERE u.active = TRUE
    |  AND o.created_at >= '2024-01-01'
    |GROUP BY u.name
    |HAVING SUM(o.total) > 100.00
    |ORDER BY total_spent DESC
    |LIMIT 10;
    |```
    |
    |## JSON
    |
    |```json
    |{
    |  "name": "markdown",
    |  "version": "0.2.0",
    |  "features": ["highlighting", "tables", "math"],
    |  "config": {
    |    "strict": true,
    |    "maxDepth": 10,
    |    "extensions": null
    |  }
    |}
    |```
    |
    |## Bash
    |
    |```bash
    |#!/bin/bash
    |
    |# Deploy script
    |set -euo pipefail
    |
    |PROJECT="myapp"
    |VERSION=$(git describe --tags)
    |
    |echo "Deploying $PROJECT v$VERSION..."
    |
    |for host in web1 web2 web3; do
    |    echo "Updating $host"
    |    scp "dist/$PROJECT.tar.gz" "$host:/opt/$PROJECT/"
    |done
    |
    |echo "Deploy complete!"
    |```
    |
    |## Supported Languages
    |
    || Language | Identifiers |
    ||----------|-------------|
    || Scala | `scala` |
    || JavaScript | `javascript`, `js`, `jsx` |
    || TypeScript | `typescript`, `ts`, `tsx` |
    || Python | `python`, `py` |
    || Java | `java` |
    || Kotlin | `kotlin` |
    || Rust | `rust` |
    || Go | `go` |
    || C | `c` |
    || C++ | `cpp`, `c++` |
    || Ruby | `ruby`, `rb` |
    || Swift | `swift` |
    || Bash | `bash`, `sh`, `shell` |
    || SQL | `sql` |
    || JSON | `json` |
    || HTML | `html` |
    || CSS | `css` |
    || YAML | `yaml`, `yml` |
    || XML | `xml` |
    || Markdown | `markdown`, `md` |""".stripMargin
