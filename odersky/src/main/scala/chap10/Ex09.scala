// Chapter 10
// Composition and Inheritance

// 10.7 Invoking superclass constructors
// 10.9 Polymorphism and dynamic binding

object Ex09 {

  abstract class Element:
    def contents: Vector[String]
    def height: Int = contents.length
    def width: Int = if height == 0 then 0 else contents(0).length
    override def toString: String = contents.mkString("\n")

  // Listing 10.5 · Defining contents as a parametric field
  class VectorElement(val contents: Vector[String]) extends Element

  // Listing 10.6 · Invoking a superclass constructor
  class LineElement(s: String) extends VectorElement(Vector(s)):
    override def width: Int = s.length
    override def height: Int = 1

  class UniformElement(
    ch: Char,
    override val width: Int,
    override val height: Int
  ) extends Element:
    private val line = ch.toString * width
    def contents: Vector[String] = Vector.fill(height)(line)


  def main(args: Array[String]): Unit = {
    val e1: Element = VectorElement(Vector("hello", "world"))
    val ve: VectorElement = LineElement("hello")
    val e2: Element = ve
    val e3: Element = UniformElement('x', 2, 3)

    println("e1 [" + e1 + "]")
    println("ae [" + ve + "]")
    println("e2 [" + e2 + "]")
    println("e3 [" + e3 + "]")
  }
}
