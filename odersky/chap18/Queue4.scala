// Chapter 18
// Type Parameterization

// 18.2 Information hiding

package chap18

object Queue4 {

  // Listing 18.2 · Hiding a primary constructor by making it private.
  class Queue[T] private
  (
    private val leading: List[T],
    private val trailing: List[T]
  ) {
    private def mirror =
      if (leading.isEmpty) new Queue(trailing.reverse, Nil)
      else this

    def head =
      mirror.leading.head

    def tail = {
      val q = mirror;
      new Queue(q.leading.tail, q.trailing)
    }

    def append(x: T) =
      new Queue(leading, x :: trailing)

    override def toString() =
      (leading ::: trailing.reverse).mkString("Queue(", ", ", ")")
  }

  // Listing 18.3 · An apply factory method in a companion object.
  object Queue:
    // constructs a queue with initial elements `xs'
    def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)

  def main(args: Array[String]): Unit = {
    val xx = Queue4.Queue(List(1, 2), List(3))
    println(xx)
    val q = Queue4.Queue[Int]().append(1).append(2).append(3)
    println(q)
  }

}

