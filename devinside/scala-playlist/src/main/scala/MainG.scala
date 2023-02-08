/* Part 12 - Closures & Function Curring */

object MainG {

  /** Closures */
  def f() = {
    
    def closedTerm2(free: Int): Int => Int =
        bound => free + bound

    def closedTerm(free: Int)(bound: Int): Int =
        free + bound
    
    def uncurriedClosedTerm(free: Int, bound: Int): Int =
        free + bound
    
    def closedTerm1(free: Int): Int => Int = {
      def openTerm(bound: Int): Int =
        free + bound
      openTerm
    }
        
    println(uncurriedClosedTerm(7, 0))
    println(uncurriedClosedTerm(10, 1))
    println(uncurriedClosedTerm(20, 2))
    println(uncurriedClosedTerm(30, 3))
    println()
    println(closedTerm(7)(0))
    println(closedTerm(10)(1))
    println(closedTerm(20)(2))
    println(closedTerm(30)(3))
  }

  /** main program */
  def mainG(args: Array[String]): Unit = {
    println("-" * 50)
    f() 
    println("-" * 50)
  }
}
