import scala.annotation.tailrec
// Chapter 8
// Functions and Closures

// 8.10 Tail recursion

object Approximate {
  private def isGoodEnough(guess: Double): Boolean = {
    println("guess [" + guess + "]")
    math.abs(guess * guess - 2.0) < 1.0E-6
  }

  private def improve(guess: Double): Double =
    (guess + 2.0 / guess) / 2.0

  @tailrec
  def approximate(guess: Double): Double =
    if isGoodEnough(guess) then guess
    else approximate(improve(guess))

  def approximateLoop(initialGuess: Double): Double =
    var guess = initialGuess
    while !isGoodEnough(guess) do
      guess = improve(guess)
    guess

  def main(args: Array[String]): Unit =
    approximateLoop(3.3)
    approximate(3.3)
}

// for `boom` see worksheet.
