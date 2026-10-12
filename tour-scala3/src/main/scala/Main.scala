@main def hello(): Unit =
  println("Hello world!")
  println(msg)

val version: String = scala.util.Properties.versionNumberString
def msg = s"I was compiled by Scala $version. :)"
