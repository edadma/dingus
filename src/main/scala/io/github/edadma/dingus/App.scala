package io.github.edadma.dingus

import io.github.edadma.fluxus.*
import io.github.edadma.fluxus.daisyui.*
import org.scalajs.dom.HTMLTextAreaElement
import org.scalajs.dom

import scala.scalajs.js
import io.github.edadma.markdown.*
import pprint.PPrinter
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

@main def run(): Unit = render(App, "app")

val initialMarkdown = """..."""
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
//val extendedSyntaxTemplate = """..."""
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
def App: FluxusNode = {
  val (markdownInput, setMarkdownInput, _) = useState("")

  // State to track the active tab
  val (activeTab, setActiveTab, _) = useState("preview")

  // Create a custom pretty printer without colors
  val noColorPPrinter = PPrinter(
    defaultHeight = 50,
    defaultWidth = 120,
    defaultIndent = 2,
    colorApplyPrefix = fansi.Attrs.Empty,
    colorLiteral = fansi.Attrs.Empty,
  )

  val dropdownLabelRef = useRef[dom.html.Element]()

  // Parse the markdown to get the document AST
  val (prettyAst, renderedHtml) = useMemo(
    () => {
      val document =
        parseDocumentContent(markdownInput, MarkdownConfig.withExtensions(tables = true, definitionLists = true))

      (noColorPPrinter.apply(document).render, renderToHTML(document))
    },
    Seq(markdownInput),
  )

  // Function to handle changes to the markdown textarea
  def handleMarkdownChange(e: dom.Event): Unit = {
    val target = e.target.asInstanceOf[HTMLTextAreaElement]
    setMarkdownInput(target.value)
  }

  // Function to clear the markdown input
  def handleClear(): Unit = {
    setMarkdownInput("")
    dom.document.querySelector("textarea").asInstanceOf[dom.html.TextArea].focus()
  }

  // Function to copy HTML to clipboard
  def copyHtmlToClipboard(): Unit = {
    dom.window.navigator.clipboard.writeText(renderedHtml)
      .toFuture
      .foreach(_ => {
        // Show notification
        dom.window.alert("HTML copied to clipboard!")
      })
  }

  // Function to load a template
  def loadTemplate(templateName: String): Unit = {
    val template = templateName match {
      case "basic" => basicSyntaxTemplate
//      case "extended" => extendedSyntaxTemplate
      case "tables" => tablesTemplate
      case "links"  => linksImagesTemplate
      case _        => initialMarkdown
    }
    setMarkdownInput(template)
  }

  // Main App Layout
  div(
    cls := "bg-base-100 min-h-screen flex flex-col",

    // Header
    div(
      cls := "text-primary-content p-4 text-center",
      h1(cls := "text-3xl font-bold", "Scala Markdown Dingus"),
      p(cls  := "opacity-90", "Interactive demo for the io.github.edadma.markdown library"),
    ),

    // Main Content Container
    Container <> ContainerProps(
      className = "flex-1 py-6",
      children = div(
        // Toolbar
        div(
          cls := "flex justify-between items-center mb-4 flex-wrap gap-2",

          // Left side of toolbar
          div(
            cls := "flex gap-2",
            Button <> ButtonProps(
              text = "Clear",
              variant = "ghost",
              onClick = () => handleClear(),
            ),
            div(
              cls := "dropdown dropdown-start", // Added dropdown-end to align it properly
              label(
                cls      := "btn btn-ghost",
                tabIndex := -1,
                ref      := dropdownLabelRef, // Add ref to the label
                "Templates",
                svg(
                  xmlns          := "http://www.w3.org/2000/svg",
                  cls            := "ml-1 h-4 w-4",
                  viewBox        := "0 0 24 24",
                  fill           := "none",
                  stroke         := "currentColor",
                  strokeWidth    := "2",
                  strokeLinecap  := "round",
                  strokeLinejoin := "round",
                  path(d := "M6 9l6 6 6-6"),
                ),
              ),
              ul(
                tabIndex := 0, // Important for keyboard navigation
                cls      := "dropdown-content z-[1] menu p-2 shadow bg-base-200 rounded-box w-52",
                li(a(
                  onClick := (() => {
                    loadTemplate("basic")
                    dropdownLabelRef.current.blur()
                    dom.document.querySelector("textarea").asInstanceOf[dom.html.TextArea].focus()
                  }),
                  "Basic Syntax",
                )),
//                li(a(onClick := (() => loadTemplate("extended")), "Extended Syntax")),
                li(a(
                  onClick := (() => {
                    loadTemplate("tables")
                    dropdownLabelRef.current.blur()
                    dom.document.querySelector("textarea").asInstanceOf[dom.html.TextArea].focus()
                  }),
                  "Tables Example",
                )),
                li(a(
                  onClick := (() => {
                    loadTemplate("links")
                    dropdownLabelRef.current.blur()
                    dom.document.querySelector("textarea").asInstanceOf[dom.html.TextArea].focus()
                  }),
                  "Links & Images",
                )),
              ),
            ),
          ),

          // Right side of toolbar
          div(
            Button <> ButtonProps(
              text = "Copy HTML",
              variant = "primary",
              onClick = () => copyHtmlToClipboard(),
            ),
          ),
        ),

        // Main content grid
        div(
          cls := "grid grid-cols-1 md:grid-cols-2 gap-4",

          // Markdown Input Panel
          Card <> CardProps(
            bordered = true,
            className = "shadow-sm",
            title = Some("Markdown Input"),
            children = div(
              textarea(
                cls       := "w-full h-[500px] p-4 font-mono text-sm focus:outline-none resize-none",
                value     := markdownInput,
                onInput   := (handleMarkdownChange(_)),
                autofocus := true,
              ),
            ),
          ),

          // Output Panel with Tabs
          Card <> CardProps(
            bordered = true,
            className = "shadow-sm",
            headerActions = Some(
              Tabs <> TabsProps(
                variant = "lifted",
                activeTab = activeTab,
                onTabChange = setActiveTab,
                children = List(
                  TabPanelProps(
                    id = "preview",
                    title = "Preview",
                    children = null,
                  ),
                  TabPanelProps(
                    id = "html",
                    title = "HTML",
                    children = null,
                  ),
//                  TabPanelProps(
//                    id = "xml",
//                    title = "XML",
//                    children = null,
//                  ),
                  TabPanelProps(
                    id = "ast",
                    title = "AST",
                    children = null,
                  ),
                ),
              ),
            ),
            children = div(
              cls := "w-full h-[500px]",

              // Preview Tab Content
              if (activeTab == "preview")
                div(
                  cls := "prose prose-invert w-full h-full overflow-auto max-w-none",
                  rawHtml(renderedHtml),
                )
              else null,

              // HTML Tab Content
              if (activeTab == "html")
                div(
                  cls := "font-mono text-sm p-4 bg-base-200 rounded-md whitespace-pre-wrap overflow-auto h-full",
                  renderedHtml,
                )
              else null,

//              // XML Tab Content
//              if (activeTab == "xml")
//                div(
//                  cls := "font-mono text-sm p-4 bg-base-200 rounded-md whitespace-pre-wrap overflow-auto h-full",
//                  renderedXml,
//                )
//              else null,

              // AST Tab Content
              if (activeTab == "ast")
                div(
                  cls := "font-mono text-sm p-4 bg-base-200 rounded-md whitespace-pre-wrap overflow-auto h-full",
                  prettyAst,
                )
              else null,
            ),
          ),
        ),
      ),
    ),

    // Footer
    div(
      cls := "p-4 text-center text-base-content/70 mt-8",
      p(
        "Powered by ",
        a(
          href   := "https://github.com/edadma/markdown",
          cls    := "link link-primary",
          target := "_blank",
          "io.github.edadma.markdown",
        ),
      ),
    ),
  )

}
