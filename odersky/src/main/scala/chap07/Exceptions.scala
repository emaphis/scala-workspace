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
      case ex3: FileNotFoundException => // Handle missing file
        println("ex3 [" + ex3 + "]")
      case ex3: IOException => // Handle other I/O error
        println("ex3 [" + ex3 + "]")


  // The `finally` clause

  // Listing 7.12 · A try-finally clause in Scala
  def finally1(): Unit =
    import java.io.FileReader

    val file = new FileReader("input.txt")
    try
      println(file.read())  // Use the file
    finally
      file.close()


  // Yielding a value

  //def f(): Int = try return 1 finally return 2
  //def g(): Int = try 1 finally 2

  // Listing 7.13 · A catch clause that yields a value.
  import java.net.URL
  import java.net.MalformedURLException

  def  urlFor(path: String): URL =
    try new URL(path)
    catch case ex4: MalformedURLException =>
      new URL("https://www.scala-lang.org")
