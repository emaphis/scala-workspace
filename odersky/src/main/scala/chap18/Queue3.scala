// Chapter 18
// Type Parameterization

// 18.1 Functional Queues

package chap18

object Queue3 {

  // Listing 18.1 · A basic functional queue.

  class Queue[T](private val leading: List[T],
                 private val trailing: List[T]):
    private def mirror =
      if leading.isEmpty then
        new Queue(trailing.reverse, Nil)
      else
        this

    def head: T = mirror.leading.head

    def tail: Queue[T] =
      val q = mirror
      new Queue(q.leading.tail, q.trailing)

    def enqueue(x: T) =
      new Queue(leading, x :: trailing)

    override def toString: String =
      (leading ::: trailing.reverse).mkString("Queue(", ", ", ")")

  object Queue:
    /// Constructs a queue with initial elements 'xs'
    def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)


  def main(args: Array[String]): Unit = {
    val q = Queue3.Queue[Int]().enqueue(1).enqueue(2).enqueue(3).enqueue(4)
    println(q)
  }
}

