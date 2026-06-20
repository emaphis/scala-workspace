// Chapter 10
// Composition and Inheritance

// 10.14 Heighten and widen

package chap10

// Listing 10.12 · Hiding implementation with private classes.
object Element:

  // Listing 10.3 · Defining VectorElement as a subclass of Element.
  private class VectorElement(val contents: Vector[String])
    extends Element

  private class LineElement(s: String) extends Element:
    val contents: Vector[String] = Vector(s)
    override def width: Int = s.length
    override def height = 1

  private class UniformElement(
    ch: Char,
    override val width: Int,
    override val height: Int
  ) extends Element:
    private val line = ch.toString * width
    def contents: Vector[String] = Vector.fill(height)(line)

  def elem(contents: Vector[String]): Element =
    VectorElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element =
    UniformElement(chr, width, height)

  def elem(line: String): Element =
    LineElement(line)

end Element


import Element.elem

// Listing 10.13 · Element with widen and heighten methods.
abstract class Element:
  def contents: Vector[String]

  // Listing 10.2 · Defining parameterless methods width and height.
  def width: Int =
    if height == 0 then 0 else contents(0).length

  def height: Int = contents.length

  def above(that: Element): Element =
    val this1 = this.widen(that.width)
    val that1 = that.widen(this.width)
    elem(this.contents ++ that.contents)

  def beside(that: Element): Element =
    val this1 = this.heighten(that.height)
    val that1 = that.heighten(this.height)
    elem (
      for (line1, line2) <- this1.contents.zip(that.contents)
      yield line1 + line2
    )

  def widen(w: Int): Element =
    if w <= width then this
    else
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right

  def heighten(h: Int): Element =
    if h <= height then this
    else
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot

  override def toString: String = contents.mkString("\n")

end Element

object LayoutElement {
  def main(args: Array[String]): Unit = {
    println("example [\n" + example + "\n]")
  }

  def example: Element = {
    val column1 = elem("Hello") above elem("***")
    val column2 = elem("***") above elem("world")
    column1 beside column2
  }
}
