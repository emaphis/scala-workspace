// Chapter 10
// Composition and Inheritance

//10.2 Abstract classes

// Listing 10.1 · Defining an abstract method and class
abstract class Element:
  def contents: Vector[String]

  // 10.3 Defining parameterless methods
  def height: Int = contents.length
  def width: Int = if height == 0 then 0 else contents(0).length


//val elem1 = new Element1 can't create abstract classes

// Listing 10.3 · Defining VectorElement as a subclass of Element.
class VectorElement(conts: Vector[String]) extends Element:
  override def contents: Vector[String] = conts

val e: Element = VectorElement((Vector("hello")))
println("e [" + e + "]")

val ve = VectorElement(Vector("hello", "world"))
ve.width
