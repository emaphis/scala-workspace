val scala3Version = "3.2.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "lesson05",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version
)
