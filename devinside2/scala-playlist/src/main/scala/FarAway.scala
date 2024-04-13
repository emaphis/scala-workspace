object FarAway {
  
  // Part 5
  val code = {
    println("I'm about to create the subroutine")

    (isSunnyDay: Boolean, isRainyDay: Boolean) =>
      if (isSunnyDay)
        "I'm happy because it's sunny"
      else if (isRainyDay)
        "I'm sad because it's raining"
      else
        "Not sure how I feel about it"
  }

  def code2(isSunnyDay: Boolean, isRainyDay: Boolean) =
    if (isSunnyDay)
      "I'm happy because it's sunny"
    else if (isRainyDay)
      "I'm sad because it's raining"
    else
      "Not sure how I feel about it"
}
