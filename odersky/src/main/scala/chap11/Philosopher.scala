// Chapter 11
// Traits

// 11.5 Trait parameters

package chap11

object Philosopher:

  class Animal

  // Listing 11.10 · Defining a trait parameter.
  trait Philosophical(message: String):
    def philosophize: String = message

  class Frog extends Animal,
    Philosophical("I croak, Therefore I am!")

  class Duck extends Animal,
    Philosophical("I quack, therefore I am!")

  // Listing 11.11 · Supplying a trait parameter.
  class ProfoundAnimal extends Animal,
    Philosophical("In the beginning was the deed.")

  // Listing 11.12 · Not supplying a trait parameter.
  class Faust extends ProfoundAnimal, Philosophical

  trait PhilosophicalAnimal extends Animal with Philosophical

  class Dog extends
    Philosophical("I bark, therefore I am."),
    PhilosophicalAnimal

  def main(args: Array[String]): Unit = {
    var philosopher: Philosophical = Frog()
    println("Frog philosophy: " + philosopher.philosophize)
    philosopher = Duck()
    println("Duck philosophy: " + philosopher.philosophize)
    philosopher = Faust()
    println("Faust philosophy: " + philosopher.philosophize)
    philosopher = Dog()
    println("Dog philosophy: " + philosopher.philosophize)
  }