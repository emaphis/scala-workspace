// Chapter 10
// Composition and Inheritance

// 10.1 A two-dimensional layout library
// 10.2 Abstract classes

object Ex01 {

  // Listing 10.1 · Defining an abstract method and class
  abstract class Element:
    def contents: Vector[String]

    // 10.3 Defining parameterless methods
    def height: Int = contents.length
    def width: Int = if height == 0 then 0 else contents(0).length


  def main(args: Array[String]): Unit = {
    val elem = new Element {
      def contents: Vector[String] = Vector("foo")
    }
    println("elem [" + elem + "]")
  }
}
