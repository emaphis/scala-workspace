// Chapter 18
// Type Parameterization


package chap18

object Queue2 {
  class SlowHeadQueue[T](smele: List[T]): // Not efficient
    // smele is elems reversed
    def head: T = smele.last
    def tail = new SlowHeadQueue(smele.init)
    def enqueue(x: T) = SlowHeadQueue(x :: smele)

    override def toString: String =
      smele.mkString("Queue(", ", ", ")")

  def main(args: Array[String]): Unit = {
    val q = new SlowHeadQueue(Nil).enqueue(1).enqueue(2)
    println(q)
  }
}
