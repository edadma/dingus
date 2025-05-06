package io.github.edadma.dingus

val linksImagesTemplate =
  """# Links and Images in Markdown
    |
    |## Basic Links
    |
    |[Link to GitHub](https://github.com)
    |
    |[Link with title](https://github.com "GitHub Homepage")
    |
    |## Reference Links
    |
    |[Reference link][1]
    |
    |[1]: https://github.com "GitHub"
    |
    |## URLs and Email Addresses
    |
    |<https://github.com>
    |
    |<example@example.com>
    |
    |## Basic Images
    |
    |![Alt text for image](https://picsum.photos/200/100 "Optional title")
    |
    |## Linked Images
    |
    |[![Alt text for image](https://picsum.photos/200/100)](https://github.com)
    |
    |## Image Sizing (using HTML)
    |
    |<img src="https://picsum.photos/200/100" width="300" height="150" alt="Resized image">
    |
    |## Image References
    |
    |![Reference image][logo]
    |
    |[logo]: https://picsum.photos/200/100 "Logo Title"
    |
    |## Images with Custom Styling (using HTML)
    |
    |<img src="https://picsum.photos/200/100" style="border-radius: 10px; box-shadow: 0 4px 8px rgba(0,0,0,0.1);" alt="Styled image">
    |""".stripMargin
