// Part 7.1 - Recursion

object Main07a {

  def main07a(args: Array[String]): Unit = {
    println("~" * 30)

    {
      def method1: String = {
        var currentIteration = 1

        @scala.annotation.tailrec
        def loop: String = {
          if (currentIteration % 5 != 0) {
            println(currentIteration)
            currentIteration += 1
            loop
          } else
            "Done!"
        }

        loop
      }

      def method2: String = {
        var currentIteration = 1;

        @scala.annotation.tailrec
        def loop(currentIteration: Int): String = {
          if (currentIteration % 5 != 0) {
            println(currentIteration)

            loop(currentIteration + 1)
          } else
            "Done!"
        }

        loop(currentIteration)
      }

      def method3: String = {
        var currentIteration = 1

        def loop: String = {
          while (currentIteration % 5 != 0) {
            println(currentIteration)
            currentIteration += 1
          }
          "Done!"
        }

        loop
      }


      println(method3)
    }

    println("~" * 30)
  }
}
