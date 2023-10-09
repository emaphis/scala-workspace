// Lesson 6 - Functions as the Most Fundamental
//            Block of Code


// 6.1 Functions

/**
  * Determine if a given number is even. 
  * Listing 6.1 The isEven function
  */
def isEven(n: Int): Boolean =
    n % 2 == 0

for(i <- 0 to 5) println(isEven(i))


// throw an exception of never terminate

def myFunc(n: Int): Boolean =
    if (n < 0) throw new RuntimeException("Error!")
    n % 2 == 0

myFunc(5)
myFunc(2) 
myFunc(0)
// myFunc(-5)  // throw exception


def myFunc2(n: Int): Boolean =
    if (n < 0) myFunc2(n)  // regresses for negative numbers
    n % 2 == 0

// The keyword 'def' and a function name
def myFunc2() = ???
// ??? is a placeholder for a future function

//  myFunc2()


// Parameter examples

def MyFunc3 = ???
def myFunc4() = ???
def myFunc5(a: Int) = ???
def MyFunc6(a: Int, b: String) = ???


// When invoking a function, you can refer to function parameters by name and
// change their order:

def myFunc7(a: Int, b: String) = ()

myFunc7(1, "Scala")             // valid
//myFunc7("Scala", 1)             // does not compile
myFunc7(a = 1, b = "Scala")     // valid
myFunc7(b = "Scala", a = 1)     // valid


// You can also specify default values for its parameters

def myFunc8(a: Int, b: String = "Hello") = ()

myFunc8(1, "Scala")         // valid
myFunc8(1)                  // valid
myFunc8(a = 1)              // valid
//smyFunc8(b = "Scala")        // does not compile
myFunc8(a = 1, b = "Scala") // valid
myFunc8(b = "Scala", a = 1) // valid


// Return types

//def myFunc10(a: Int)    // wont compile - cant guess return type
//def myFunc11(a: Int): Int // wont compile, no body
def myFunc12(a: Int) = a + 1
def myFunc13(a: Int): Int = {
     a + 1
}
// def myFunc14(a: Int): Boolean = {  // no compile, wrong return type
//     a + 1
//}


// Implementation

// def myFunc14(a: Int): Boolean   // missing body is only valid for class bodies

//abstract def myFunc15(a: Int): Boolean  // 'abstract' is only valid for classes

def myFunc16(a: Int): Int = {    // valid function body
    a + 1
}

def myFunc17(a: Int): Int = a + 1  // missing { } is valie

def myFunc18(a: Int): Int = {           // valid
    println("...exxtra opperation...")
    a + 1
}

def myFunc19(a: Int): Int =            // valid inScala 3
    println("...exxtra opperation...")
    a + 1
