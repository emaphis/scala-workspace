// Quick Check 5

// 5.1 Write a function called evenOrOdd that takes an integer and prints
//     a message to the console to tell if a number is even or odd. 
// HINT: Use the modulo operator % for the remainder of a division
//       (e.g., 5 % 2 returns 1).

def  evenOrOdd(n: Int) =
    if (n % 2 == 0)
        println(s"$n is even")
    else
        println(s"$n is odd")

evenOrOdd(5)
evenOrOdd(20)


//  5.2 Write a function, called count, to print all the numbers from 1 to 10
//  using a while loop.

def count() =
    var i: Int = 1
    while (i <= 10)
        println(i)
        i += 1

count()


// 5.3 Does the following expression compile? If so, what is its output? ]
//     for (a <- "hello") println(a)
// Use the REPL to validate your hypothesis
// A- Yes, it compiles and runs
for (a <- "hello") println(a)
