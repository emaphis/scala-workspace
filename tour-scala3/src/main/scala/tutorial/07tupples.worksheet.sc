// Tuples

// a tuple is a value that contains a fixed number of elements, each with its own type.

val ingredient = ("Sugar", 25)


//* Accessing the elements *
// tuple(0), tuple(1)

println(ingredient(0))
println(ingredient(1))


//* Pattern matching on tuples *

val (name, quantity) = ingredient
println(name)
println(quantity)

// Here is another example of pattern-matching a tuple:
val planets =
  List(("Mercury", 57.9), ("Venus", 108.2), ("Earth", 149.6),
    ("Mars", 227.9), ("Jupiter", 778.3))

planets.foreach {
  case ("Earth", distance) =>
    println(s"Our planet is $distance million kilometers from the sun")
  case _ =>
}

// Or, in a for comprehension:
val numPairs = List((2, 5), (3, -7), (20, 56))
for (a, b) <- numPairs do
  println(a * b)

  
