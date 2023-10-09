// Lesson 12  - Traits as Interfces

/*
Quick Check 12.1 Define an interface called Printable that enforces the presence
of a function called print: it takes no parameters, and it returns Unit
*/

trait Printable {
    def print(): Unit
}

class Marker(mark: String) extends Printable {
    def print() = println(mark)
}

val printer: Printable = new Marker("mark")
printer.print()


/*
Quick Check 12.2 Which of the following statements are correct? Use the REPL
to validate your hypothesis.
1 A class can extend a class.
2 A class can extend an object.
3 A class can extend a trait.
4 An object can extend a class.
5 An object can extend an object.
6 An object can extend a trait.
7 A trait can extend a class.
8 A trait can extend an object.
9 A trait can extend a trait.
*/

class MyClass
object MyObj
trait MyTrait

// 1 A class can extend a class.
// a. Yes
class MyClass1 extends MyClass

// 2 A class can extend an object.
// a. No
//class MyClass2 extends MyObj  // wont compile

// 3 A class can extend a trait.
// a. Yes
class MyClass3 extends MyTrait

// 4 An object can extend a class.
// a. Yes
object MyObj2 extends MyClass

// 5 An object can extend an object.
// a. No
//object MyObj3 extends MyObj   // wont compile

// 6 An object can extend a trait.
// a. Yes
object MyObj4 extends MyTrait

// 7 A trait can extend a class.
// a. Yes
trait MyTrait2 extends MyClass

// 8 A trait can extend an object.
// a. No
//rait MyTrait3 extends MyObj  // wont compile

// 9 A trait can extend a trait.
// a. Yes
trait MyTrait4 extends MyTrait


/*
Quick Check 12.3 Define a trait, called Currency, with only
 three possible imple￾mentations: USD, CAD, and EUR.
*/
sealed trait Currency

object USD extends Currency
object CAD extends Currency
object EUR extends Currency

val cur: Currency = EUR

/*
Quick Check 12.4 In Quick Check 12.3, you implemented a sealed trait Currency
with three implementations; reimplement it using enumeration syntax for Scala 3.
*/

enum Currency2 {
    case USD, CAD, EUR
}

Currency2.USD
