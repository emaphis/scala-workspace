// Chapter 10
// Composition and Inheritance

// 10.5 Overriding methods and fields

object Ex03 {

  abstract class Element:
    def contents: Vector[String]
    def height: Int = contents.length
    def width: Int = if height == 0 then 0 else contents(0).length
    override def toString: String = contents.mkString("\n")

  // Listing 10.4 · Overriding a parameterless method with a field.
  class VectorElement(conts: Vector[String]) extends Element:
    val contents: Vector[String] = conts


  def main(args: Array[String]): Unit = {
    val arrayElem = new VectorElement(Vector("foo"))
    println("arrayElem [" + arrayElem + "]")
  }
}
