// Lesson 6 - Quick Check

// 6.1 Which of the following functions do not compile? Why?
// 1 def myFunc1(x) = x + 1              // bad - need parameter types 
// 2 def myFunc2(x: Int) = x + 1         // Ok
// 3 def myFunc3(x: Int = true): Int     // bad - missing body, bad types
// 4 def myFunc4(x: Int)                 // bad - missing body
// 5 def myFunc5(x: Int): Int = x == 1   // bad return type
// 6 def myFunc6(x: Int) = x == 1        // Ok

// 6.1 Which of the following functions do not compile? Why?
//def myFunc1(x) = x + 1
def myFunc2(x: Int) = x + 1
//def myFunc3(x: Int = true): Int
//def myFunc4(x: Int):
//def myFunc5(x: Int): Int = x == 1
def myFunc6(x: Int) = x == 1

//val xxx = myFunc5(5)
//println(xxx)
