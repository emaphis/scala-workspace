// Lesson 12  - Traits as Interfaces

/// 12.1 Defining traits

// 12.1 Defining traits
trait Animal {

    def sleep = "ZzZ"

    def eat(food: String): String

    def move(x: Int, y: Int): String
}

//val an1 = new Animal1  // wont compile


// Listing 12.2 The trait Nameable

trait Nameable {
    def name: String
}

// can be written in Scala 3 as
trait Nameable2(name: String)
 

///.12.2 Extending traits

// Listing 12.3 The Cat class
class Cat extends Animal {

    override val sleep = "sleepy cat!"

    override def eat(food: String): String = s"a car is eating $food"

    override def move(x: Int, y: Int): String = s"the cat is moving to ($x,$y)"

}


// Listing 12.4 The Dog class
class Dog(val name: String) extends Animal with Nameable {

    override def eat(food: String): String = s"$food $food"

    override def move(x: Int, y: Int): String = s"let's go to ($x, $y)"
}


val tiggerTheDog = new Dog("Tigger")
val cat = new Cat

def feedTreet(animal: Animal) =
    animal.eat("treet")

feedTreet(tiggerTheDog)
feedTreet(cat)

def welcome(nameable: Nameable) =
    println(s"Hi, ${nameable.name}!")

welcome(tiggerTheDog)
//welcome(cat)  // doesn't compile


/// 12.3 Sealed traits

// Listing 12.5 Suits of poker cards

sealed trait Suit

object Clubs extends Suit
object Diamonds extends Suit
object Hearts extends Suit
object Spades extends Suit


/// 12.4 Enumeration in Scala 3

// Listing 12.6 Suits of poker cards using enumeration

enum  Suit2 {
    case Clubs, Diamonds, Hearts, Spades
}

Suit2.Hearts
Suit2.values
Suit2.fromOrdinal(0)


// Listing 12.7 A list of countries and codes 

enum Country(val code: String) {
    case Italy extends Country("IT")
    case UnitedKingdom extends Country("UK")
    case UnitedStates extends Country("US")
    case Japan extends Country("JP")
}

Country.UnitedKingdom.code
