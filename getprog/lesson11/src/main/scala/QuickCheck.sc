// Lesson 11 - Singleton Object


/*
Quick Check 11.1 Consider the following snippet of code. Does this code compile?
Why? Use the REPL to validate your hypothesis. 

// Answer:
// No, it doesn't compile.  objects only create singletons that can't be created using `new`

object MySnippet
new MySnippet
*/

object MySnippet

//val snipp = new MySnippet   // wont compile
// Not found: type MySnippet


/*
Quick Check 11.2 When running your program with sbt, what happens if it cannot
find its main entry point? What if it finds more than one? Verify your hypothesis by
writing two simple programs and executing them with sbt: one with no main, the
other with two

// Answer:
// a. Without a main method SBT returns "java.lang.RuntimeException: No main class detected"
//    exception

// b. SBT run presents a list of main methods to run
*/


/*
Quick Check 11.3 Consider the function welcome defined in the class Robot. Is it a
static method? Why?

Answer:
No, It's a public member of the Robot heiarche
*/


/*
Quick Check 11.4 Consider this snippet of code. Are the expressions new
Dog("Tigger") and Dog("Tigger") equivalent? Why?

Answer:
No, both expressions produce different objects, (at different addresses)
*/

class Dog(val name: String)

object Dog {
    def apply(name: String): Dog = 
        new Dog(s"$name The Dog")
}

new Dog("Tigger").name
Dog("Tigger").name

//val res4: String = Tigger
//val res5: String = Tigger The Dog
