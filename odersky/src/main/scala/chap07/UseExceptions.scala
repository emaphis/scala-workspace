// Chapter 7
// Built-in Control Structures
// 7.4 Exception handling with try expressions

package chap07

object UseExceptions:
  def main(args: Array[String]): Unit = {
    println("Hello, world")

    try
      Exceptions.throws1()
    catch
      case ex1: Throwable =>
        println("ex1 [" + ex1 + "]")

    try
      println("Exceptions.half(2) [" + Exceptions.half(2) + "]")
      Exceptions.half(3)
    catch
      case ex2: Throwable =>
        println("ex2 [" + ex2 + "]")

    Exceptions.throws3()

    try
      Exceptions.finally1()
    catch
      case ex4: Throwable =>
        println("ex4 [" + ex4 + "]")

    //println("Exceptions.f [" + Exceptions.f() + "]")
    //println("Exceptions.g [" + Exceptions.g() + "]")

    println("Exceptions.urlFor(\"blah\") [" + Exceptions.urlFor("blah") + "]")
  }
