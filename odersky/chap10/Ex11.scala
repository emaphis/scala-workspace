// Chapter 10
// Composition and Inheritance

// 10.11 Using composition and inheritance
// 10.12 Implementing `above`, `beside`, and `toString`

object Ex11  {

  // Listing 10.9 · Class Element with `above`, `beside`, and `toString`.
  abstract class Element:
    def contents: Vector[String]
    def height: Int = contents.length
    def width: Int = if height == 0 then 0 else contents(0).length

    def above(that: Element): Element =
      VectorElement(this.contents ++ that.contents)

    def beside(that: Element): Element =
      VectorElement(
        for (line1, line2) <- this.contents.zip(that.contents)
        yield line1 + line2)

    override def toString: String = contents.mkString("\n")

  end Element

  class LineElement(s: String) extends Element:
    val contents: Vector[String] = Vector(s)
    override def width: Int = s.length
    override def height: Int = 1

  class VectorElement(conts: Vector[String]) extends Element:
    def contents: Vector[String] = conts

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
