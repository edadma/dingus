import { defineConfig } from "vite";
import scalaJSPlugin from "@scala-js/vite-plugin-scalajs";
import tailwindcss from '@tailwindcss/vite'

export default defineConfig({
  plugins: [scalaJSPlugin(), tailwindcss()],
  base: './',
  build: {
    outDir: 'docs', // Output to docs folder instead of dist
    emptyOutDir: true // Clear the output directory before building
  }
});
