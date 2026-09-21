// Basics

//* Expressions *
// Computable statements

1 + 1

// Output the results of expressions

println(1)
println(1 + 1)
println("Hello!")
println("Hello, " + " world!")


// Values
// You can name the results of expressions

val x = 1 + 1
println(x)

// values are immutable
// x = 3  // will not compile

// Types can be inferred or explicitly stated
val y: Int = x + x

// Variables
// Mutable memory locations

var z = 1 + 1
z = 3  // This compiles because "Z" is declared with the "var" keyword.
println(x * x)


//* Blocks *
// Combine expressions with {}

println({
    val x = 1 + 1
    x + 1
})


//* Functions *
// Expressions that have parameters and take arguments


(x: Int) => x + 1

// Name functions
val addOne = (x: Int) => x + 1
println(addOne(1))

// Functions can have multiple parameters
val add = (x: Int, y: Int) => x + y

// ... or no parameters
val getTheAnswer = () => 42
println(getTheAnswer())

val whatEver = () => ()


//* Methods *
// Methods are defined with the 'def' keyword. 
// 'def' is followed by a name, parameter list(s), a return type, and a body:

def add1(x: Int, y: Int): Int = x + y
println(add1(1, 2))

// A method can take multiple parameter lists
def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
println(addThenMultiply(1, 2)(3))


// No parameter war
def name: String = System.getProperty("user.name")
println("Hello, " + name + "!")


// Methods can have multi-line expressions as well
def getSquareString(input: Double): String =
  val square = input * input
  square.toString

println(getSquareString(2.5))


//* Classes *
// You can define classes with the class keyword, followed by its name and constructor parameters

class Greeter(prefix: String, suffix: String):
  def greet(name: String): Unit =
    println(prefix + name + suffix)

val greeter1 = Greeter("Hello, ", "!")
greeter1.greet("Scala developer")


//* Case Classes *

case class Point(x: Int, y: Int)

// You can instantiate case classes without the new keyword
val point = Point(1, 2)
val anotherPoint = Point(1, 2)
val yetAnotherPoint = Point(2, 2)

// Instances of case classes are compared by value, not by reference
if point == anotherPoint then
    println(s"$point and $anotherPoint are the same.")
else
    println(s"$point and $anotherPoint are different.")

if point == yetAnotherPoint then
  println(s"$point and $yetAnotherPoint are the same.")
else
  println(s"$point and $yetAnotherPoint are different.")    


//* Objects *
// Objects are single instances of their own definitions.
// You can think of them as singletons of their own classes.

object IdFactory:
    private var counter = 0
    def create(): Int =
        counter 
        counter += 1
        counter

// You can access an object by referring to its name
val newId: Int = IdFactory.create()
println(newId)

val newerId: Int = IdFactory.create()
println(newerId)


//* Traits */
// Traits are abstract data types containing certain fields and methods.
// In Scala inheritance, a class can only extend one other class, but it can extend multiple traits.

trait Greeter1:
    def greet(name: String): Unit

// Traits can also have default implementations
trait Greeter2:
    def greet(name: String): Unit =
        println("Hello, " + name + "!")

// You can extend traits with the extends keyword and override
// an implementation with the override keyword:

class DefaultGreeter extends Greeter2 

class CustomizableGreeter(prefix: String, postfix: String) extends Greeter2:
  override def greet(name: String): Unit =
    println(prefix + name + postfix)


val greeter = DefaultGreeter()
greeter.greet("Scala developer")

val customGreeter = CustomizableGreeter("How are you, ", "?")
customGreeter.greet("Scala developer")


//* Program Entry Point *
// The main method is the entry point of a Scala program.
// The Java Virtual Machine requires a main method, named main,
// that takes one argument: an array of strings.

// See App.scals
