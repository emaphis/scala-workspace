// Chapter 18
// Type Parameterization

// 18.1 Functional queues

// head     returns the first element of the queue
// tail     returns a queue without its first element
// enqueue  returns a new queue with a given element
//          appended at the end

import scala.collection.immutable.Queue

val q = Queue(1, 2, 3)
val q1 = q.enqueue(4)
q



object Queue3 {

  // Listing 18.1 · A basic functional queue.

  class Queue[T](private val leading: List[T],
                 private val trailing: List[T]):
    private def mirror =
      if leading.isEmpty then
        new Queue(trailing.reverse, Nil)
      else
        this

    def head = mirror.leading.head

    def tail =
      val q = mirror
      new Queue(q.leading.tail, q.trailing)

    def enqueue(x: T) =
      new Queue(leading, x :: trailing)
  
  object Queue:
    /// Constructs a queue with initial elements 'xs'
    def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
}

def run3(): Unit =
  val q = Queue3.Queue[Int]().enqueue(1).enqueue(2)
  println(q)
  
run3()

