object MainD {

  /** Range */
  def f1() = {
    println(1 to 10: Range.Inclusive)
    println(1 until 10: Range)
    println("****")
    1 to 5 foreach println
    println("****")
    1 until 6 foreach println
    println("****")
    'a' to 'f' foreach println
    println("****")
    'A' to 'F' foreach println
    println("****")
    println("****")
  }

  /** Range 2 */
  def f2() = {
    def isEven(x: Int): Boolean = x % 2 == 0
    def isOdd(x: Int): Boolean = x % 2 != 0

    0 to 10 foreach { i =>
      if (isOdd(i))
        println(i)
    }
  }

  /** modulo seconds in a minute */
  def f() = {
    var secondsInAMinute = 60

    50 to 70 foreach { i =>
      println(i % secondsInAMinute)
    }
  }

  def mainD(args: Array[String]): Unit = {
    println("-" * 50)
    f()
    println("-" * 50)
  }
}
