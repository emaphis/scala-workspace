// Part 4 - if expressions can be complicated

object Main4 {

  def hi = "hello"

  def main4(args: Array[String]): Unit = {
    println("~" * 50)

    {
      def isSunnyDay = true
      def isRainyDay = false

      def result = {
        if (isSunnyDay)
          "I'm happy because it's sunny"
        else if (isRainyDay)
          "I'm sad because it's raining"
        else
          "Not sure how I feel about it"
      }

      println(result)

      // types
      println(10)
      println(true)
      println("true")

      // more scopes
      println(Main4.hi)
      println(FarAway.hello)
    }

    println("~" * 50)
  }
}

object FarAway {
    def hello = "hi"
}