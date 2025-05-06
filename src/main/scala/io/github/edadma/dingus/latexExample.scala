package io.github.edadma.dingus

val latexExample =
  """# Markdown Math Examples
    |
    |This document shows how to write math in Markdown using KaTeX-style delimiters.
    |
    |## Inline Math
    |
    |You can write math inline between single dollar signs:
    |
    |- The Pythagorean theorem is $a^2 + b^2 = c^2$.
    |- The quadratic formula is $x = \frac{-b \pm \sqrt{b^2 - 4ac}}{2a}$.
    |- Euler’s identity is $e^{i\pi} + 1 = 0$.
    |
    |Escaping a dollar sign: `\$` produces \$.
    |
    |## Display Math
    |
    |For centered, standalone equations, use double dollar signs:
    |
    |$$
    |\int_{-\infty}^{\infty} e^{-x^2}\,dx = \sqrt{\pi}
    |$$
    |
    |You can also include multiple lines in one display block:
    |
    |$$
    |\int_{0}^{\infty} e^{-x}\,dx = 1 \\
    |\sum_{n=1}^{\infty} \frac{1}{n^2} = \frac{\pi^2}{6}
    |$$
    |
    |Or combine different famous formulas:
    |
    |$$
    |\begin{align}
    |\frac{d}{dx} \sin x &= \cos x, \\
    |\frac{d}{dx} \cos x &= -\sin x \\
    |\end{align}
    |$$
    |
    |## More Examples
    |
    |- A simple exponential: $f(t) = e^{\lambda t}$
    |- A definite integral: $\int_{-1}^{1} x^2 \,dx = \frac{2}{3}$
    |- A sum with factorials: $\sum_{k=0}^{\infty} \frac{1}{k!} = e$$
    |
    |Enjoy writing beautiful math in your Markdown!
    |""".stripMargin
