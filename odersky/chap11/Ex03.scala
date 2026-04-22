// Chapter 11
// Traits

// 11.4 Why not multiple inheritance?

package chap11

object Ex03:

  class Animal
  trait Furry extends Animal
  trait HasLegs extends Animal
  trait FourLegged extends HasLegs

  class Cat extends Animal, Furry, FourLegged

  def main(args: Array[String]): Unit = {
    val cat = new Cat
    println("cat [" + cat + "]")
  }
