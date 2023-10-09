// Video # 19 - 
object MainN {

  /** Pattern matching examples */
  def code(args: Array[String]) = {
    val one = 1
    def method(input: Any): Any = input match {
      case 2   => 2
      case one => one
      case _   => "I'm here!"
    }

    def show(input: Any): Unit = {
      println(method(input))
    }

    show(1)
    show(2)
    show(true)
    show(false)
    show("hi")
    show('c')
    
    println("\nHello Video 19!")
  }

  /** main program */
  def main(args: Array[String]): Unit = {
    println("-" * 80)
    code(args)
    println("-" * 80)
  }
}
