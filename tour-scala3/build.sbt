val scala3Version = "3.9.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "tour-scala3",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "1.3.6" % Test
    //javaSource := (javaSource.value ++ Seq(file("src/main/java"))).map(_.relativeTo(baseDirectory).get)
  )
