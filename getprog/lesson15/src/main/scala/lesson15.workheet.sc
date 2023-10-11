// Lesson 15 - Anonymous functions

// Consider two functions:

//def sum(a: Int, b: Int): Int = a + b
//def subtract(a: Int, b: Int): Int = a - b

// 15.1 Function vs. anonymous function


// Listing 15.2 MySecondCalculator program

object MyCalculator {

    def sum(a: Int, b: Int): Int = a + b

    def subtract(a: Int, b: Int): Int = a - b

    def multiply(a: Int, b: Int): Int = a * b

    def divide(a: Int, b: Int): Int = a / b

    def negate(a: Int): Int = subtract(0, a)

}

import MyCalculator.*

MyCalculator.sum(3, 5)      // returns 8
subtract(4, 4) // returns 0
multiply(5, 3) // returns 15
divide(6, 2)   // returns 3
negate(-5)     // returns 5

object MySecondCalculator {

    def sum2 = { (a: Int, b: Int) => a + b }

    def subtract2 = {(a: Int, b: Int) => a - b}

    def multiply2 = {(a: Int, b: Int) => a * b}

    def divide2 = {(a: Int, b: Int) => a / b}

    def negate2 = {(a: Int) => subtract2(0, a)}

}

// Listing 15. MySecondCalculator program
import MySecondCalculator._

sum2(3, 5)      // returns 8
subtract2(4, 4) // returns 0
multiply2(5, 3) // returns 15
divide2(6, 2)   // returns 3
negate2(-5)     // returns 5


//Listing 15.3 MyThirdCalculator program

object MyThirdCalculator {

    def sum3: (Int, Int) => Int = {_ + _}

    def subtract3: (Int, Int) => Int = {_ - _}

    def multiply3: (Int, Int) => Int = {_ * _}

    def divide3: (a: Int, b: Int) => Int = {_ / _}

    def negate3: Int => Int = subtract3(0, _)

}

import MyThirdCalculator._

sum3(3, 5)      // returns 8
subtract3(4, 4) // returns 0
multiply3(5, 3) // returns 15
divide3(6, 2)   // returns 3
negate3(-5)     // returns 5
