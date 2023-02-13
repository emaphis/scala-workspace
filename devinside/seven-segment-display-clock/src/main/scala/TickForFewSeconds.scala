import Constants._
import scala.concurrent.duration.DurationInt
import scala.concurrent.duration.FiniteDuration


object TickUntilEnterisPressed {

  def main(args: Array[String]): Unit = {
    Scala.tickUntilEnterIsPressed(Interval) {
      Terminal.clearCanvas()
      Terminal.goUp(LinesToGoUp)

      TwoDimensionalTime.showCurrent(TimePattern)
    }

    println()
  }
}

object TickForFewSeconds {

  def main(args: Array[String]): Unit = {
    Scala.loop(times = FewSeconds) {
      Terminal.clearCanvas()
      Terminal.goUp(LinesToGoUp)

      TwoDimensionalTime.showCurrent(TimePattern)

      Scala.wait(Interval)
    }

    println()
  }
}

object Constants {
  val FewSeconds: Int = 10
  val TimePattern: String = "HH:mm:ss"
  val Interval: FiniteDuration = 1.second
  val LinesToGoUp: Int = Int.MaxValue
}
