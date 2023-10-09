import my.example.io.MyExample

@main def hello: Unit =
  val example = new MyExample()
  val file = example.readFileIntoString("build.sbt")
  println(file)
