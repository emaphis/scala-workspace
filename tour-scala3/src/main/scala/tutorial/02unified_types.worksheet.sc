// Unified Types

//* Scala Type Hierarchy *

// example that demonstrates that strings, integers, characters, boolean values, and functions are all of type Any just like every other object
val list: List[Any] = List(
  "a string",
  732,  // an integer
  'c',  // a character
  true, // a boolean value
  () => "an anonymous function returning a string"
)

list.foreach(element => println(element))


//* Type Casting *

val x: Long = 987654321
val y: Float = x.toFloat

val face: Char = '☺'
val number: Int = face

// Casting is unidirectional. This will not compile
val x1: Long = 987654321
val y1: Float = x1.toFloat
//val z1: Long = y


//* Nothing and Null *
// Nothing
// Null
