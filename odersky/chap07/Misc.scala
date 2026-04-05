// Chapter 7
// Built-in Control Structures
package chap07

import scala.annotation.tailrec

object Misc {

  // 7.1 If expressions

  def ifVariations(args: Array[String]): Unit = {
    println("args: [" + args.toList + "]")

    {
      var fileName = "default.txt"
      if !args.isEmpty then
        fileName = args(0)
      println("filename [" + fileName + "]")
    }

    {  // Listing 7.1 · Scala’s idiom for conditional initialization.
      val fileName =
        if !args.isEmpty then args(0)
        else "default.txt"
      println("filename [" + fileName + "]")
    }

    println(if (!args.isEmpty) args(0) else "default.txt")
  }

  // 7.2 While loops

  // Listing 7.2 · Calculating greatest common divisor with a while loop.
  def gcdLoop(x: Long, y: Long): Long =
    var a = x
    var b = y
    while a != 0 do
      val temp = a
      a = b % a
      b = temp
    b

  // Listing 7.3 · Executing a loop body at least once without do-while.

  private var loopCounter = 2

  def whileLoop(): Unit =
    def readLine() =
      if loopCounter > 0 then
        loopCounter -= 1
        "a line.."
      else
        ""

    while
      val line = readLine()
      println(s"Read: $line")
      line != ""
    do ()

  // Listing 7.4 · Calculating greatest common divisor with recursion.
  @tailrec
  def gcd(x: Long, y: Long): Long =
    if y == 0 then x else gcd(y, x % y)

}
