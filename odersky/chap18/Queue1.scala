// Chapter 18
// Type Parameterization

// 18.1 Functional queues

package chap18

object Queue1:

  class SlowAppendQueue[T](elems: List[T]):   // Not efficient
    def head = elems.head
    def tail = new SlowAppendQueue(elems.tail)
    def enqueue(x: T) = SlowAppendQueue(elems ::: List(x))

    override def toString: String =
      elems.mkString("Queue(", ", ", ")")


  def main(args: Array[String]): Unit =
    val q = new SlowAppendQueue(Nil).enqueue(1).enqueue(2)
    println(q)
