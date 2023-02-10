// Lesson 6 - Try This

/*
TRY THIS
Define a function pow that takes two parameters of type Int and that returns an
Int; call the first parameter exponent and the second one base with a default of
2. The function should calculate the power of a number as follows: if the param￾eter exponent has a value of 3 and base 2, it should compute 23. Implement the
function using a loop without using the function Math.pow.
*/

def pow(exp: Int, base: Int): Int =
    var accum = 1
    for(_ <- 1 to exp)
        accum *= base
    accum
 
pow(1, 1) == 1
pow(2, 2) == 4
pow(3, 2) == 8
pow(2, 3) == 9
pow(3, 3) == 27
pow(3, 10) == 1000
