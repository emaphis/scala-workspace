// Class Composition with Mixins

// Mixins are traits which are used to compose a class.

abstract class A:
  val message: String

class B extends A:
  val message = "I'm an instance of class B"

trait C extends A:
  def loudMessage = message.toUpperCase()

class D extends B, C

val d = D()
println(d.message)
println(d.loudMessage)


// example starting with an abstract class:

abstract class AbsIterator:
  type T
  def hasNext: Boolean
  def next(): T

class StringIterator(s: String) extends AbsIterator:
  type T = Char
  private var i = 0
  def hasNext = i < s.length
  def next() =
    val ch = s.charAt(i)
    i += 1
    ch

// Now let’s create a trait which also extends AbsIterator.
trait RichIterator extends AbsIterator:
  def foreach(f: T => Unit): Unit = while hasNext do f(next())

// combine the functionality of StringIterator and RichIterator into a single class.
class RichStringIter(str: String) extends StringIterator(str), RichIterator

val richStringIter = RichStringIter("Scala")
richStringIter.foreach(println)
