ThisBuild / version := "0.1.0"

ThisBuild / scalaVersion := "3.3.7"

ThisBuild / scalacOptions ++= List("-feature", "-deprecation", "-Ykind-projector:underscores", "-source:future")

ThisBuild / libraryDependencies += "org.scalameta" %% "munit" % "1.2.4S" % Test

lazy val root = (project in file("."))
  .settings(
    name := "functional-programming"
  )
