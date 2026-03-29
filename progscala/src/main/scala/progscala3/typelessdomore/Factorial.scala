// Nesting Method Definitions and Recursion

package progscala3.typelessdomore

import scala.annotation.tailrec

def factorial(i: Int): BigInt =
  @tailrec
  def fact(i: Int, accumulator: BigInt): BigInt =
    if i <= 1 then accumulator
    else fact(i - 1, i * accumulator)

  fact(i, BigInt(1))


@main def main3(): Unit =
  (0 to 10).foreach(i => println(s"$i: ${factorial((i))}"))
