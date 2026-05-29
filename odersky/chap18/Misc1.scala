// Chapter 18
// Type Parameterization

package chap18

// 18.3 Variance annotations

object Misc1 {

  // Listing 18.5 · A nonvariant (rigid) Cell class
  class Cell[T](init: T):
    private var current = init

    def get: T = current

    def set(x: T): Unit =
      current = x


  def main(args: Array[String]): Unit = {
    val c1 = Cell[String]("abc")
    //val c2: Cell[Any] = c1
    //c2.set(1)
    //val s: String = c1.get
  }
}
