
object MainB {
  def main1(args: Array[String]): Unit = {
    println("-" * 50)
    
    {
      def factorial(n: Int): Int = {
        @scala.annotation.tailrec
        def loop(x: Int, accm: Int): Int = {
          if (x == 0 || x == 1)
            accm
          else
            loop(x - 1, x * accm)
        }

        loop(n, 1)
      }

      println(factorial(19))

      def fibonacci(n: Int): Int = {
        @scala.annotation.tailrec
        def loop(x: Int, accu1: Int, accu2: Int): Int = {
          if (x == 0) accu1
          else if (x == 1) accu2
          else loop(x = x - 1, accu1 = accu2, accu2 = accu1 + accu2)
        }
        loop(n, 0, 1)
      }

      println(fibonacci(0))
      println(fibonacci(1))
      println(fibonacci(2))
      println(fibonacci(3))
      println(fibonacci(4))
      println(fibonacci(5))
      println(fibonacci(6))
      println(fibonacci(7))
      println(fibonacci(8))


      
    }
    
    println("-" * 50)
  }
}
