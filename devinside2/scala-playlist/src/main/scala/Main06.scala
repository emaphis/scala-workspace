// Part 6 - (Sub)routines

object Main06 {

  def main06(args: Array[String]): Unit = {
    println("~" * 50)

    {
      val frozenCode = FarAway.code
      val frozenCode2: (Boolean, Boolean) => String = FarAway.code2
      println(FarAway.code2(true, true))
      println()

      println(FarAway.code2(true, false))
      println()

      println(FarAway.code2(false, true))
      println()

      println(FarAway.code2(false, false))
    }

    println("~" * 50)
  }
}
