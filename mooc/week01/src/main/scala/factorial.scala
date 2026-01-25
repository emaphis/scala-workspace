// Tail recursive version of factorial
 
import scala.annotation.tailrec

def factorial(n: Int): Int =

    @tailrec 
    def loop(n: Int, acc: Int): Int =
        if n == 0 then acc 
        else loop(n - 1, n * acc)

    loop(n, 1)

@main def testFactorial = println(factorial(5))
