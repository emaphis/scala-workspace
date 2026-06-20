// Lists in Scala

object Lists1 {
  def main(args: Array[String]): Unit = {
    val oneTwoThree = List(1, 2, 3)
    println("oneTwoThree [" + oneTwoThree + "]")

    // adding elements :::
    val oneTwo = List(1, 2)
    val threeFour = List(3, 4)
    val oneTwoThreeFour = oneTwo ::: threeFour
    println("oneTwoThreeFour [" + oneTwoThreeFour + "]")

    // concatenation
    val twoThree = List(2, 3)
    val oneTwoThree2 = 1 :: twoThree
    println("oneTwoThree2 [" + oneTwoThree2 + "]")

    // an empty list is Nil
    val oneTwoThree3 = 1 :: 2 :: 3 :: Nil
    println("oneTwoThree3 [" + oneTwoThree3 + "]")
  }
}
