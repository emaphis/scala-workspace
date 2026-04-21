// Chapter 10
// Composition and Inheritance

// 10.6 Defining parametric fields

object Ex05 {

  abstract class Element:
    def contents: Vector[String]
    def height: Int = contents.length
    def width: Int = if height == 0 then 0 else contents(0).length
    override def toString: String = contents.mkString("\n")

  // Listing 10.5 · Defining contents as a parametric field
  class VectorElement(val contents: Vector[String]) extends Element

  def main(args: Array[String]): Unit = {
    val arrayElem = new VectorElement(Vector("foo"))
    println("arrayElem [" + arrayElem + "]")
  }
}
