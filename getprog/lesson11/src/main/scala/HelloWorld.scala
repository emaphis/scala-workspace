// Lesson 11  - Singleton Objects

// 11.2 Executable object

// Listing 11.3 Hello World!

object HelloWorld {

  // def main(args: Array[String]): Unit = {
  //   println("Hello world")
  // }

  // Scala 3: @main annotation
  @main def hello: Unit = {
    println("Hello from @main")
  }

  // Command line arguements
  // $ sbt
  // run 5 test
  // testtesttesttesttest
  //@main
  //def echo(n: Int, word: String) = {
  //    println(word * n)
  //}
}
