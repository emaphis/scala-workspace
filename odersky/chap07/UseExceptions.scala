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
      case ex: Throwable =>
        println("ex [" + ex + "]")

    try
      println("Exceptions.half(2) [" + Exceptions.half(2) + "]")
      Exceptions.half(3)
    catch
      case ex: Throwable =>
        println("ex [" + ex + "]")

    Exceptions.throws3()



  }

