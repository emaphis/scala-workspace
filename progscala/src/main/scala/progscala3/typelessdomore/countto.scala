package progscala3.typelessdomore

import scala.annotation.tailrec

// The nested function can see anything in scope, including
// arguments passed to the outer function.

def countTo(n: Int): Unit =
  @tailrec
  def count(i: Int): Unit =
    if i <= n then
      println(i)
      count(i + 1)

  count(1)

@main def testCount(): Unit = countTo(5)
