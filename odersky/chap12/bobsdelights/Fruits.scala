// Chapter 12
// Packages, Imports, and Exports

// 12.3 Imports

// Listing 12.7 · Bob’s delightful fruits, ready for import.

package chap12.bobsdelights

abstract class Fruit(val name: String, val color: String)

object Fruits:
  object Apple extends Fruit("apple", "red")
  object Orange extends Fruit("orange", "orange")
  object Pear extends Fruit("pear", "yellowish")
  val menu: List[Fruit] = List(Apple, Orange, Pear)
