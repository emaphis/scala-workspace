val scala3Version = "3.3.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "what-time-is-it",
    version := "0.1",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
  )
