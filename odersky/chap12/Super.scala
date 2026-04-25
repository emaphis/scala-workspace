// Chapter 12
// Packages, Imports, and Exports

// 12.5 Access modifiers
// Protected members

// Listing 12.11 · How protected access differs in Scala and Java.
package p:

  class Super:
    protected def f: String = "f"

  class Sub extends Super:
    val obj1: String = f

  // cannot access protected members
  //class Other:
  //  val obj2: String = (new Super).f
