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
println(q)


// 18.3 Variance annotations



// 18.4 Checking variance annotations
