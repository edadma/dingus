package io.github.edadma.dingus

import io.github.edadma.fluxus.*
import io.github.edadma.fluxus.remix.{BookOpenLine, BookOpenLineProps}
import io.github.edadma.fluxus.daisyui._
import org.scalajs.dom.document
import org.scalajs.dom
import scala.scalajs.js
import org.scalajs.dom.HTMLTextAreaElement
import io.github.edadma.markdown._
import pprint.PPrinter
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

@main def run(): Unit = render(App, "app")

val initialMarkdown = """..."""
val basicSyntaxTemplate =
  """
    |
    |- a
    |
    |asdf
    |
    |- a
    |
    |asdf
    |
    |- a
    |
    |asdf
    |
    |- a
    |
    |asdf
    |
    |- a
    |
    |asdf
    |
    |- a
    |
    |asdf
    |
    |""".stripMargin
val extendedSyntaxTemplate = """..."""
val tablesTemplate         = """..."""
val linksImagesTemplate    = """..."""

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

  // Parse the markdown to get the document AST
  val document = parseDocumentContent(markdownInput)

  // Generate pretty-printed AST string using pprint without colors
  val prettyAst = noColorPPrinter.apply(document).render

  // Render markdown to HTML
  val renderedHtml = renderToHTML(document)

  // Function to handle changes to the markdown textarea
  def handleMarkdownChange(e: dom.Event): Unit = {
    val target = e.target.asInstanceOf[HTMLTextAreaElement]
    setMarkdownInput(target.value)
  }

  // Function to clear the markdown input
  def handleClear(): Unit = {
    setMarkdownInput("")
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
      case "basic"    => basicSyntaxTemplate
      case "extended" => extendedSyntaxTemplate
      case "tables"   => tablesTemplate
      case "links"    => linksImagesTemplate
      case _          => initialMarkdown
    }
    setMarkdownInput(template)
  }

  // Main App Layout
  div(
    cls := "bg-base-100 min-h-screen flex flex-col",

    // Header
    div(
      cls := "bg-primary text-primary-content p-4 text-center shadow-md",
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

            // Template dropdown
            div(
              cls := "dropdown",
              Button <> ButtonProps(
                text = "Templates",
                variant = "ghost",
                endIcon = Some(
                  svg(
                    xmlns          := "http://www.w3.org/2000/svg",
                    width          := "16",
                    height         := "16",
                    viewBox        := "0 0 24 24",
                    fill           := "none",
                    stroke         := "currentColor",
                    strokeWidth    := "2",
                    strokeLinecap  := "round",
                    strokeLinejoin := "round",
                    path(d := "M6 9l6 6 6-6"),
                  ),
                ),
              ),
              ul(
                cls := "dropdown-content z-[1] menu p-2 shadow bg-base-200 rounded-box w-52",
                li(a(onClick := (() => loadTemplate("basic")), "Basic Syntax")),
                li(a(onClick := (() => loadTemplate("extended")), "Extended Syntax")),
                li(a(onClick := (() => loadTemplate("tables")), "Tables Example")),
                li(a(onClick := (() => loadTemplate("links")), "Links & Images")),
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
                cls     := "w-full h-[400px] min-h-[400px] p-4 font-mono text-sm focus:outline-none resize-none",
                value   := markdownInput,
                onInput := (handleMarkdownChange(_)),
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
                  TabPanelProps(
                    id = "ast",
                    title = "AST",
                    children = null,
                  ),
                ),
              ),
            ),
            children = div(
              cls := "w-full h-[400px]",

              // Preview Tab Content
              if (activeTab == "preview")
                div(
                  cls := "prose prose-invert w-full h-full overflow-auto",
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
      cls := "bg-base-200 p-4 text-center text-base-content/70 mt-8",
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
