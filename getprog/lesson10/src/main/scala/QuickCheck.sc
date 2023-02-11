// Lesson 10  - Quick Check

/*
Quick Check 10.1 In the REPL, declare a value called name, containing the string
Scala; make it publicly usable.
*/

val name = "Scala"


/*
Quick Check 10.2 Consider the following snippet of code: is age accessible from
the class Student? Use the REPL to validate your hypothesis. 

    class Person {
        private val age = 18 
    }

    class Student extends Person
*/
// Answer:  No, the value is accesible from the Person class
class Person {
    private val age = 18 
}

class Student extends Person {
    // def printAge() = println(age)   // wont compile
}

val std = new Student

//std.age  // wont compile
//std.printAge()


/*
Quick Check 10.3 Can you access the function estimateCosts from outside the
class Event? Use the REPL to validate your hypothesis. 
*/

class Event4 {
    protected def estimatedCosts(attendees: Int): Double =
        if (attendees < 10) 50.00 else attendees * 12.34
}

class Party4 extends Event4 {
    private var attendees = 0

    def cost = estimatedCosts(attendees)

    def register(guests: Int) =
        attendees += guests
}

val evn = new Event4

// evn.estimatedCosts(13)  // no access
