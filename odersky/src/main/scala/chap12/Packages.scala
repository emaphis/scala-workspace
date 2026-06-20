// Chapter 12
// Packages, Imports, and Exports

// 12.3 Imports

import chap12.bobsdelights.{Fruit, Fruits}
import chap12.bobsdelights.Fruits.*

object Packages:

    // Listing 12.8 · Importing the members of a regular (not singleton) object.
    def showFruit(fruit: Fruit): String =
      import fruit.*
      s"${name}s are $color"

    def main(args: Array[String]): Unit = {
      println("Apple [" + Apple + "]")
      println(showFruit(Fruits.Apple))
    }
