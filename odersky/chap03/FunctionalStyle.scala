import scala.annotation.tailrec

//
object FunctionalStyle {
  def main(args: Array[String]): Unit = {
    // imperative style
    def printArgsI(args: List[String]): Unit =
      var i = 0
      while i < args.length do
        println(args(i))
        i += 1

    printArgsI(List("zero", "one", "two"))

    // refactored style
    def printArgsR(args: List[String]): Unit =
      for arg <- args do
        println(arg)

    printArgsR(List("three", "four", "five"))

    // different style
    def printArgsD(args: List[String]): Unit =
      args.foreach(println)

    printArgsD(List("six", "seven", "eight"))

    // Listing 3.9 · A function without side effects or vars
    def formatArgs(args: List[String]) = args.mkString("\n")

    def printArgsF(args: List[String]): Unit =
      println(formatArgs(args))

    printArgsF(List("nine", "ten"))
    println("whew")
  }
}
