// Chapter 7
// Built-in Control Structures
// 7.4 Exception handling with try expressions

package chap07

object Exceptions:

  def throws1(): Unit =
    throw new IllegalArgumentException

  def half(n: Int): Int =
    if n % 2 == 0 then
      n / 2
    else
      throw new RuntimeException("n must be even")


  // Catching exceptions

  // Listing 7.11 · A try-catch clause in Scala.
  def throws3(): Unit =
    import java.io.FileReader
    import java.io.FileNotFoundException
    import java.io.IOException

    try
      val f = new FileReader("input.txt")
      // use and close file
      println("f [" + f + "]")
    catch
      case ex: FileNotFoundException => // Handle missing file
        println("ex [" + ex + "]")
      case ex: IOException => // Handle other I/O error
        println("ex [" + ex + "]")


  // The finally clause