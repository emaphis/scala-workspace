// Chapter 12
// Packages, Imports, and Exports

// 12.5 Access modifiers
// Private members

// Listing 12.10 · How private access differs in Scala and Java.
class Outer:
  class Inner:
    private def f = "f"

    class InnerMost:
      val obj: String = f  // accessible

  // 'f' is inaccessible because it's private
  //val obj2 = (new Inner).f
