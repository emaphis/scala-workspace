// Chapter 15
// Working with Other Collections

// 15.3 Selecting mutable versus immutable collections

package chap15

object Capitals {
  def useImmut(): Unit =
    var capital = Map("US" -> "Washington", "France" -> "Paris")
    capital += ("Japan" -> "Tokyo")
    println(capital("France"))

  def useMut(): Unit =
    import scala.collection.mutable.Map // only change needed
    var capital = Map("US" -> "Washington", "France" -> "Paris")
    capital += ("Japan" -> "Tokyo")
    println(capital("France"))

  def main(args: Array[String]): Unit = {
    println("Capitals: ")
    useImmut()
    useMut()
  }
}
