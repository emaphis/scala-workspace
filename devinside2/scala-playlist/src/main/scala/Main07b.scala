// Part 7.2 - Recursion

object Main07b {

  def main7b(args: Array[String]): Unit = {
    println("~" * 30)

    {
      def factorial(n: Int): Int = {

        @scala.annotation.tailrec
        def loop(x: Int, accu: Int): Int = {
          if (x == 0)
            accu
          else
            loop(x - 1, accu * x)
        }

        loop(n, 1)
      }

      def fibonacci(n: Int): Int = {
        @scala.annotation.tailrec
        def loop(x: Int, accu1: Int, accu2: Int): Int = {
          if (x == 0)
            accu1
          else if (x == 1)
            accu2
          else
            loop(x - 1, accu2, accu1 + accu2)
        }

        loop(n, 0, 1)
      }

      println(fibonacci((0)))
      println(fibonacci((1)))
      println(fibonacci((2)))
      println(fibonacci((3)))
      println(fibonacci((4)))
      println(fibonacci((5)))
      println(fibonacci((6)))
      println(fibonacci((7)))
      println(fibonacci((8)))
      println(fibonacci((45)))
    }

    println("~" * 30)
  }
}
