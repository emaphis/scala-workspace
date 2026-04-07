import scala.annotation.tailrec
// Chapter 8
// Functions and Closures


// 8.3 First-class functions

//(x: Int) => x + 1

val increase = (x: Int) => x + 1

// More than one expression
val addTwo = (x: Int) =>
  val increment = 2
  x + increment

 val someNumbers = List(-11,-10,-5, 0, 5, 10)

someNumbers.foreach((x: Int) => println(x))

someNumbers.filter((x: Int) => x > 0)


// 8.4 Short forms of function literals

// inferred parameter types, unnecessary parentheses
someNumbers.filter(x => x > 0)


// 8.5 Placeholder syntax

someNumbers.filter(_ > 0)

// if types can't ge inferred
val f = (_: Int) + (_: Int)
f(5, 10)


// 8.6 Partially applied functions

def sum(a: Int, b: Int, c: Int) = a + b + c

sum(1, 2, 3)

val a = sum(_, _, _) // a has type (Int, Int, Int) => Int
//val a = sum _

a(1, 2, 3)

// a(1, 2, 3) is a short form for:
a.apply(1, 2, 3)

val b = sum(1, _, 3)

b(2)
b(5)

//val c = sum

//c(10, 20, 30)


// 8.7 Closures

//(x: Int) => x + more

var more = 1
val addMore = (x: Int) => x + more
addMore(10)

more = 9999
addMore(10)

//  Changes made by a closure to a captured variable
//  are visible outside the closure.

val someNumbers1 = List(-11,-10,-5, 0, 5, 10)
var sum = 0
someNumbers.foreach(sum += _)
sum

// here is a function that creates and returns “increase” closures:
def makeIncreaser(more: Int) = (x: Int) => x + more

val inc1 = makeIncreaser(1)
val inc9999 = makeIncreaser(9999)

inc1(10)
inc9999(10)


// 8.8 Special function call forms

// Repeated parameters

def echo(args: String*): Unit =
  for arg <- args do println(arg)

echo()
echo("one")
echo("one", "two")
echo("Hello", "world", "!")

val seq1 = Seq("What's", "up", "doc?")
//echo(seq1)
echo(seq1*)

// Named arguments

def speed(distance: Float, time: Float): Float = distance / time

speed(100, 10)
speed(distance = 100, time = 10)
speed(time = 10, distance = 100)

// Default parameter values

// Listing 8.4 · A function with two parameters that have defaults.
def point(x: Int = 0, y: Int = 0) = (x, y)

point(x = 42)
point(y = 1000)


// 8.10 Tail recursion

// Tracing tail-recursive functions

def boom(x: Int): Int =
  if x == 0 then throw new Exception("boom!")
  else boom(x - 1) + 1

//boom(3)
//java.lang.Exception: boom!

@tailrec
def bang(x: Int): Int =
  if x == 0 then throw new Exception("bang!")
  else bang(x - 1)

//bang(5)
//java.lang.Exception: bang!
