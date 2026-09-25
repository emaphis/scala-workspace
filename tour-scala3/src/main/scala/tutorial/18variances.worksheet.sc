// Variances

class Foo[+A] // A covariant class
class Bar[-A] // A contravariant class
class Baz[A]  // An invariant class

// Invariance
// By default, type parameters in Scala are invariant: subtyping relationships between the type parameters aren’t reflected in the parameterized type

class Box[A](var content: A)

abstract class Animal:
  def name: String

case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal

// Well typed
val myAnimal: Animal = Cat("Felix")

val myCatBox: Box[Cat] = Box[Cat](Cat("Felix"))
//val myAnimalBox: Box[Animal] = myCatBox // this doesn't compile
//val myAnimal: Animal = myAnimalBox.content

// We can also replace the cat in the box with a different animal
val myAnimalBox: Box[Animal] = Box(Cat("Felix"))
myAnimalBox.content = Dog("Fido")

val myCat: Cat = myCatBox.content // oops


// Covariance

class ImmutableBox[+A](val content: A)
val catBox: ImmutableBox[Cat] = ImmutableBox[Cat](Cat("Felix"))
val animalBox: ImmutableBox[Animal] = catBox // now this compiles





