// Main application

@main
def hello(): Unit =
  println("Hello world!")
  println(msg)

def msg: String = "I was compiled by Scala " + getVersion + " :)"

def getVersion: String =
  val compilerVersion = scala.util.Properties.versionString
  compilerVersion