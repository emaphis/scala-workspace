// Quick Check  - Lesson 16

/*
    Quick Check 16.1 Define a partial function called transform that reverses strings
    starting with an “a” and converts to uppercase all those beginning with an “s.” Use
    the startsWith, reverse, and toUpperCase functions of the class String.
*/

val transform: PartialFunction[String, String] =
    case s if s.startsWith("s") => s.reverse
    case s if s.startsWith("a") => s.toUpperCase

transform("start") == "trats"
transform("alpha") == "ALPHA"


/*
Quick Check 16.2 Consider the partial functions sqrt and zero in listing 16.4. Is
the partial function sqrt.orElse(zero) equivalent to zero.orElse(sqrt)?
*/

val sqrt: PartialFunction[Int, Double] =
    { case x if x >= 0 => Math.sqrt(x) }

val zero: PartialFunction[Int, Double] = { case _ => 0 }

def sqrtOrZero(n: Int): Double = sqrt.orElse(zero)(n)
def zeroOrSqrt(n: Int): Double = zero.orElse(sqrt)(n)

sqrtOrZero(4)  == 2.0
zeroOrSqrt(4)  == 0.0

// Not equivalent: order of operations are different leading to different output

/*
Quick Check 16.3 The following expression throws an IllegalArgumentException
exception:

    val b = "hello".toBoolean

Write a try-catch expression to default any non-parsable value to false. 
*/

val b =
    try
        "hello".toBoolean
    catch
        case _: IllegalArgumentException  => false

b == false
