// Chapter 18
// Type Parameterization

// 18.2 Information hiding

package chap18

// Listing 18.4 · Type abstraction for functional queues.
// An alternative: private classes
object Queue6 {

  trait Queue[T]:
    def head: T
    def tail: Queue[T]
    def enqueue(x: T): Queue[T]

  object Queue:

    def apply[T](xs: T*): Queue[T] =
      QueueImpl[T](xs.toList, Nil)

    private class QueueImpl[T]
    (
      private val leading: List[T],
      private val trailing: List[T]
    ) extends Queue[T]:

      def mirror: QueueImpl[T] =
        if leading.isEmpty then
          QueueImpl(trailing.reverse, Nil)
        else this

      override def head: T = mirror.leading.head

      override def tail: QueueImpl[T] =
        val q = mirror
        QueueImpl[T](q.leading.tail, q.trailing)

      override def toString(): String =
        (leading ::: trailing.reverse).mkString("Queue(", ", ", ")")

      def enqueue(x: T) =
        QueueImpl(leading, x :: trailing)


  def main(args: Array[String]): Unit = {
    val q = Queue[Int]().enqueue(1).enqueue(2).enqueue(3)
    println(q)
  }
}
