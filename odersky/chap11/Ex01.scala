// Chapter 11
// Traits

// 11.1 How traits work

package chap11

// Listing 11.2 · Mixing in a trait using extends.
// Listing 11.3 · Mixing in a trait using a comma

object Ex01:
  class Animal
  trait HasLegs

  class Frog extends Animal, Philosophical, HasLegs:
    override def toString: String = "green"


  def main(args: Array[String]): Unit =
    val frog = new Frog
    //frog.philosphize

    val phil: Philosophical = frog
    println("frog's philosophy: " + phil.philosophize)
