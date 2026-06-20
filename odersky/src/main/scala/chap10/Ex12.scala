import Ex09.UniformElement
// Chapter 10
// Composition and Inheritance

// 10.13 Defining a factory object

object Ex12  {

  // Listing 10.11 · Class Element refactored to use factory methods

  import Element.elem

  abstract class Element:
    def contents: Vector[String]
    def height: Int = contents.length
    def width: Int = if height == 0 then 0 else contents(0).length

    def above(that: Element): Element =
      elem(this.contents ++ that.contents)

    def beside(that: Element): Element =
      elem(
        for (line1, line2) <- this.contents.zip(that.contents)
        yield line1 + line2
      )

    override def toString: String = contents.mkString("\n")

  end Element

  // Listing 10.10 · A factory object with factory methods.
  object Element:

    def elem(contents: Vector[String]): Element =
      VectorElement(contents)

    def elem(chr: Char, width: Int, height: Int): Element =
      UniformElement(chr, width, height)

    def elem(line: String): Element =
      LineElement(line)


  class LineElement(s: String) extends Element:
    val contents: Vector[String] = Vector(s)
    override def width: Int = s.length
    override def height: Int = 1

  class VectorElement(conts: Vector[String]) extends Element:
    def contents: Vector[String] = conts

  class UniformElement(
                        ch: Char,
                        override val width: Int,
                        override val height: Int
                      ) extends Element:
    private val line = ch.toString * width

    def contents: Vector[String] = Vector.fill(height)(line)

  def main(args: Array[String]): Unit = {
    val lineElem = new LineElement("foo")
    println("lineElem [" + lineElem + "]")

    val zip1 =
      Vector(1, 2, 3).zip(Vector("a", "b"))
    val zip2 =
      Vector((1, "a"), (2, "b"))
    println("zip1 [" + zip1 + "]")
    println("zip2 [" + zip2 + "]")
  }
}
