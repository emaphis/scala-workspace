// Chapter 10
// Composition and Inheritance

// 10.4 Extending classes

object Ex02 {

  abstract class Element:
    def contents: Vector[String]
    def height: Int = contents.length
    def width: Int = if height == 0 then 0 else contents(0).length
    override def toString: String = contents.mkString("\n")

  // Listing 10.3 · Defining VectorElement as a subclass of Element.
  class VectorElement(conts: Vector[String]) extends Element:
    override def contents: Vector[String] = conts


  def main(args: Array[String]): Unit = {
    val arrayElem = new VectorElement(Vector("foo"))
    println("arrayElem [" + arrayElem + "]")

    val a123 = Array(1, 2, 3).mkString("Array(", ", ", ")")
    val abcLen = "abc".length
    val helloLen = "hello".length
    println()

    val e: Element = VectorElement(Vector("hello"))

    println("a123 [" + a123 + "]")
    println("abcLen [" + abcLen + "]")
    println("helloLen [" + helloLen + "]")
    println("e [" + e + "]")
  }
}
