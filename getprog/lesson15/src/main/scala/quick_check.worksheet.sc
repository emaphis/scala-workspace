// Quick Check Lesson 15

/*
Quick Check 15.1 What is the type for each of the values defined in listing 15.2?
Use the REPL to validate your hypothesis.

sum: (Int, Int) => Int
subtract: (Int, Int) => Int
multiply: (Int, Int) => Int
divide: (Int, Int) => Int
negate: Int => Int
*/


/*
Quick Check 15.2 Write an anonymous function equivalent to the following function:
 
 def hello(n: String): String = s"Hello, $n!" 
*/

def hello0(n: String): String = s"Hello, $n!"
val hello = (n: String) => s"Hello, $n!"

hello0("world")
hello("World")

/*
Quick Check 15.3 Are functions funcA and funcB equivalent? In other words, do
they return the same output when receiving the same input? Why? Use the REPL to
verify your hypotheses.
 
 val funcA: (Int, Int) => Int = { (a, b) => b / a }
 val funcB: (Int, Int) => Int = { _ / _ } 
*/

val funcA: (Int, Int) => Int = { (a, b) => b / a }
val funcB: (Int, Int) => Int = { _ / _ }

funcA(2, 4) == 2
funcB(2, 4) == 0
funcB(4, 2) == 2

// No they aren't equivalent, order of parameters is different.
