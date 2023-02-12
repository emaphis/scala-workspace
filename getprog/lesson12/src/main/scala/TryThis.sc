// // Lesson 12  - Try This

/*
TRY THIS Implement an interface to ensure the presence of a field color.
Define two classes that conform to your interface: one to represent furniture,
the other clothes.
*/

trait Color {
    val color: String
}

class Furnature(val color: String) extends Color

class Clothing(val color: String) extends Color

val chair = new Furnature("red")
val shirt = new Clothing("blue")

chair.color
shirt.color
