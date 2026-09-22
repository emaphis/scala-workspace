// Traits

//* Defining a trait *

// A simple trait
trait HairColor

// Traits become especially useful as generic types and with abstract methods

trait Iterator[A]:
  def hasNext: Boolean
  def next(): A


// Using traits

class IntIterator(to: Int) extends Iterator[Int]:
  private var current = 0
  override def hasNext: Boolean = current < to
  override def next(): Int =
    if hasNext then
      val t = current
      current += 1
      t
    else
       0
end IntIterator

val iterator = IntIterator(10)
iterator.next()
iterator.next()
iterator.hasNext


//* Subtyping *

import scala.collection.mutable.ArrayBuffer

trait Pet:
  val name: String

class Cat(val name: String) extends Pet
class Dog(val name: String) extends Pet

val dog = Dog("Harry")
val cat = Cat("Sally")

val animals = ArrayBuffer.empty[Pet]
animals.append(dog)
animals.append(cat)

animals.foreach(pet => println(pet.name))
