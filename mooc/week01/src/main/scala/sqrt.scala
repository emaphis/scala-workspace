// Sqrt definition from Lecture 1.6 - Blocks and Lexical Scope

def square(x: Double): Double = x * x
def abs(x: Double): Double = if x > 0 then x else -x


def sqrt(x: Double): Double = {
    def sqrtIter(guess: Double): Double =
        if isGoodEnough(guess) then guess
        else sqrtIter(improve(guess))

    def improve(guess: Double): Double =
        (guess + x / guess) / 2.0

    def isGoodEnough(guess: Double): Boolean =
        abs(guess * guess - x) < 0.001

    sqrtIter(1.0)
}


@main def test = println(sqrt(2.0))


