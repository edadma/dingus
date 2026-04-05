ThisBuild / licenses += "MIT"  -> url("https://opensource.org/licenses/MIT")
ThisBuild / versionScheme      := Some("semver-spec")
ThisBuild / evictionErrorLevel := Level.Warn

lazy val dingus = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
//  .enablePlugins(ScalablyTypedConverterPlugin)
  .settings(
    name         := "dingus",
    version      := "0.0.1",
    scalaVersion := "3.8.2",
    organization := "io.github.edadma",
    jsEnv        := new org.scalajs.jsenv.nodejs.NodeJSEnv(),
    libraryDependencies ++= Seq(
      "io.github.cquiroz" %%% "scala-java-time" % "2.6.0",
      "io.github.edadma"  %%% "fluxus"          % "0.0.34",
      "io.github.edadma"  %%% "fluxus-daisyui"  % "0.0.7",
      "io.github.edadma"  %%% "markdown"        % "0.4.0",
      "io.github.edadma"  %%% "highlighter"     % "0.0.1",
      "com.lihaoyi"       %%% "pprint"          % "0.9.0",
    ),
    resolvers += "Sonatype OSS Releases" at "https://s01.oss.sonatype.org/content/repositories/releases",
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.ESModule) },
    scalaJSLinkerConfig ~= { _.withSourceMap(false) },
    publishMavenStyle      := true,
    Test / publishArtifact := false,
    licenses += "ISC"      -> url("https://opensource.org/licenses/ISC"),
  )
