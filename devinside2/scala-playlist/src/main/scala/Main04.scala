// Part 4 - if expressions can be complicated

object Main04 {

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
      println(Main04.hi)
      println(FarAway1.hello)
    }

    println("~" * 50)
  }
}

object FarAway1 {
    def hello = "hi"
}