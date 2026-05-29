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


// 18.3 Variance annotations

import chap18.Queue4

//def doesNotCompile(q: Queue4.Queue) = {}
// missing type parameter for Queue

def doesCompile(q: Queue[AnyRef]) = {}
// def doesCompile(q: Queue[AnyRef]): Unit


import chap18.Misc1.Cell

val c1 = new Cell[String]("abc")
//val c2: Cell[Any] = c1
//c2.set(1)
//val s: String = c2


