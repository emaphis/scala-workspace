// Video #18 - Anonymous Functions and Partial

object MainM {

  /** An Example */
  def code(args: Array[String]) = {

    val totalFunction: Int => String = 
      argument => "\"" + argument + "\"";

    type ->[-Input, +Output] = PartialFunction[Input, Output]

    val partialFunction: Int -> String = {
      case 4 => "\"" + 4 + "\""
    }

    val totalFunctionWithoutSyntaxSugar: Function1[Int, String] = new Function1[Int, String] {
      override def apply(argument: Int): String =
        "\"" + argument + "\"";
    }

    
    val partialFunctionWithoutSyntaxSugar: PartialFunction[Int, String] = new PartialFunction[Int, String] {
      override def apply(argument: Int): String =
        if (argument == 4)
          "\"" + argument + "\"";
        else
          sys.error("You were supposed to test input with the `isDefinedAt` method!!")

      override def isDefinedAt(argument: Int): Boolean =
        if (argument == 4)
          true
        else
          false
    }

    println(" " + 4)
    println(totalFunction(4))
    println(totalFunctionWithoutSyntaxSugar(4))

    println("\n " + 4)
    println(partialFunction(4))
    if (partialFunctionWithoutSyntaxSugar.isDefinedAt(4))
      println(partialFunctionWithoutSyntaxSugar(4))

  }

  /** main program */
  def mainM(args: Array[String]): Unit = {
    println("-" * 80)
    code(args)
    println("-" * 80)
  }
}
