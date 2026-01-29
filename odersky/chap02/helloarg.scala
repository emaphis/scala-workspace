// Step4. Write some Scala scripts
// Consuming command-line arguments

// run with `--` to provide command-line arguments
// > scala ./helloarg.scala -- Alice

@main def m2(args: String*) =
  println("Hello, " + args(0) + "!")
