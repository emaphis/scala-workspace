object Main {

  /** An Example */
  def f() = {
    println("Hello")
  }

  /** main program */
  def mainT(args: Array[String]): Unit = {
    println("-" * 50)
    f()
    println("-" * 50)
  }
}
