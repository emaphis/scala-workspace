// Lesson 16 - Partial functions

// Listing 16.1 Square root of an integer functions

def sqrtOrZero(n: Int): Double =
    n match
        case x if x >= 0 => Math.sqrt(x)
        case _ => 0

def sqrtOrValue(n: Int): Double =
    n match
        case x if x >= 0 => Math.sqrt(x)
        case x  => x


// 16.1.1 Implementing a partial function

// // Listing 16.2  A partial sqrt function

val sqrt: PartialFunction[Int, Double] =
    { case x if x >= 0 => Math.sqrt(x) }


// Listing 16.3 A toPrettyString function

val toPrettyString: PartialFunction[Any, String] =
    case x: Int if x > 0 => s"positive number: $x"
    case s: String  => s

toPrettyString(1)  == "positive number: 1"
toPrettyString("hello") == "hello"
//toPrettyString(-1)  // Match error


// 16.1.2 Function composition

val f: String => Int = _.size
val g: Int => Boolean = _ > 2

// A new function calling f and then g:
val gof: String => Boolean = { s => g(f(s))}

gof("A")   == false
gof("AA")  == false
gof("AAA") == true


val gof2: String => Boolean = f.andThen(g)

gof2("A")   == false
gof2("AA")  == false
gof2("AAA") == true


// Listing 16.4 Two square root functions

//val sqrt: PartialFunction[Int, Double] =
//    { case x if x >=0 => Math.sqrt(x) }
// See above

val zero: PartialFunction[Int, Double] = { case _ => 0 }

val value: PartialFunction[Int, Double] = { case x => x }

def sqrtOrZero1(n: Int): Double = sqrt.orElse(zero)(n)
def sqrtOrValue1(n: Int): Double = sqrt.orElse(value)(n)


// 16.2 Use case: Exception handling

class MyException(msg: String) extends Exception(msg)

// throw new MyException("BOOM!")

// Listing 16.5 An exception handling example

def n(): Int =
    try
        throw new MyException("BOOM!")
    catch
        case ex: MyException =>
            println(s"Ignore exception $ex. Returning zero instead") 
            0

n()  == 0
