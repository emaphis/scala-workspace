object MainE {

  /** Composing functions */
  def f() = {
    val f: Int => Int = _ + 5
    val g: Int => Int = _ /2
    
    println(f(15))      // 15 + 5 -> 20
    println(g(20))      // 10 / 2 -> 10
    
    println("****")
    
    println(f(g(20)))   // (20 / 2) + 5  -> 15
    println(g(f(15)))   // (15 + 5) / 2  -> 10
    
    println("****")
    
    def rightThenLeft(left: Int => Int, right: Int => Int): Int => Int =
      n => left(right(n))

    val gThenF = rightThenLeft(f, g)
    println(gThenF(20))

    def leftTheRight(left: Int => Int, right: Int => Int): Int => Int =
      n => right(left(n))

    val FThenG = leftTheRight(f, g)
    println(FThenG(15))

    println("****")

    val gThenF2 = f compose g
    println(gThenF2(20))

    val fThenG2 = g compose f
    println(fThenG2(15))

    println("****")
    
    val gThenF3 = g andThen f
    println(gThenF3(20))

    val fThenG3 = f andThen g
    println(fThenG3(15))

    println("****")
  }

  /** main program */
  def mainG(args: Array[String]): Unit = {
    println("-" * 50)
    f()
    println("-" * 50)
  }
}
