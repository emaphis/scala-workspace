val scala3Version = "3.3.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "lesson10",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version
  )
