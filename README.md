# Markdown Dingus

An interactive playground demonstrating the capabilities of the [io.github.edadma.markdown](https://github.com/edadma/markdown) Scala library.

## Live Demo

Try it online: [Markdown Dingus](https://edadma.github.io/dingus/)

## Features

- **Live Preview**: See your Markdown rendered in real-time
- **HTML Output**: View and copy the generated HTML
- **AST Visualization**: Explore the Abstract Syntax Tree
- **Rich Markdown Support**:
    - Standard Markdown syntax
    - Tables with alignment options
    - Fenced code blocks with syntax highlighting
    - LaTeX math expressions (via KaTeX)
    - GitHub-style emoji shortcodes (:smile:)
    - Callout blocks for notes, warnings, and tips
    - Auto-linked URLs and more

## Getting Started

### Prerequisites

- [SBT](https://www.scala-sbt.org/) (1.8.0+)
- [Node.js](https://nodejs.org/) (16.0.0+)
- [npm](https://www.npmjs.com/) (8.0.0+)

### Installation

1. Clone the repository
   ```bash
   git clone https://github.com/edadma/dingus.git
   cd dingus
   ```

2. Install dependencies
   ```bash
   npm install
   ```

### Development

Run the development server:

```bash
# Terminal 1: Compile Scala.js code
sbt ~fastLinkJS

# Terminal 2: Start the development server
npm run dev
```

Then open [http://localhost:5173](http://localhost:5173) in your browser.

### Build for Production

```bash
# Build the project
npm run build
```

This will create a production build in the `docs` folder, ready to be deployed to GitHub Pages or any other static hosting service.

## Usage Guide

### Basic Editing

Type or paste Markdown content in the left panel to see it rendered in real-time on the right panel.

### Templates

Click the "Templates" dropdown to load example Markdown demonstrating various features:

- Basic Syntax
- Tables
- LaTeX Math
- Links & Images
- Emojis
- And more

### View Options

Toggle between different views using the tabs:

- **Preview**: Rendered Markdown output
- **HTML**: Generated HTML code
- **AST**: Abstract Syntax Tree visualization

## Technology Stack

- [Scala.js](https://www.scala-js.org/) - Scala to JavaScript compiler
- [Fluxus](https://github.com/edadma/fluxus) - UI framework for Scala.js
- [Fluxus-DaisyUI](https://github.com/edadma/fluxus-daisyui) - DaisyUI components for Fluxus
- [io.github.edadma.markdown](https://github.com/edadma/markdown) - Markdown parsing and rendering library
- [Vite](https://vitejs.dev/) - Frontend build tool
- [Tailwind CSS](https://tailwindcss.com/) - Utility-first CSS framework
- [DaisyUI](https://daisyui.com/) - Tailwind CSS component library
- [KaTeX](https://katex.org/) - Math typesetting library

## Contributing

Contributions are welcome! Here are ways you can contribute:

1. Report bugs and request features via [GitHub Issues](https://github.com/edadma/dingus/issues)
2. Submit [Pull Requests](https://github.com/edadma/dingus/pulls) with bug fixes or new features
3. Improve documentation

Please ensure your code follows the project's coding standards and includes appropriate tests.

## License

This project is licensed under the [ISC License](LICENSE).

## Acknowledgments

- Markdown Dingus is inspired by the [CommonMark Dingus](https://spec.commonmark.org/dingus/)
- Emoji support based on GitHub's emoji shortcodes
- Math rendering powered by KaTeX
