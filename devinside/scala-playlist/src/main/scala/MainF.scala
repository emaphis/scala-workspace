object MainF {

    def factorial(n: Int): Int =
      if (n == 0) 1
      else n * factorial(n - 1)

    def fibonacci(n: Int): Int =
      if (n == 0) 0
      else if (n == 1) 1
      else fibonacci(n - 1) + fibonacci(n - 2)

  /** Higher order functions */
  def f() = {    
    def showRange(functionName: String, arguments: Range, function: Int => Int): Unit = {
      arguments foreach { argument =>
        show(functionName, argument, function)
      }
    }

    def show(functionName: String, argument: Int, function: Int => Int): Unit =
      println(highererOrderedRender(functionName, argument, function))

    def highererOrderedRender(functionName: String, argument: Int, function: Int => Int): String =
      lowerOrderedRender(functionName, argument, function(argument))

    def lowerOrderedRender(functionName: String, argument: Int, result: Int): String =
      s"Function: $functionName\tArgument: $argument\tResult: $result" 

    show("+ 5", 10, _ + 5)
    show("/ 2", 20, _ / 2)
    show("* 3", 2, _ * 3)
    show("mod 2", 9, _ % 2)
    show("mod 2", 10, _ % 2)
    println()
    showRange("factorial", 0 to 5, factorial)
    println()
    showRange("fibonacci", 0 to 6, fibonacci)
  }

  /** main program */
  def mainF(args: Array[String]): Unit = {
    println("-" * 50)
    f()
    println("-" * 50)
  }
}
