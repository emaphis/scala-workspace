// Lesson 11 - Singleton Objects

/// 11.1 Object

abstract class Robot0(name: String) {
    def welcome: String
}


/**
 * Vocabulary of sentances that a Robot can use.
 * Listing 11.1 A vocabulary object
 */
object Vocabulary {
    val sentenceA = "Hi there!"
    val sentenceB = "Welcome"
    val sentenceC = "Hello :)"
}

Vocabulary.sentenceA
Vocabulary.sentenceB
Vocabulary.sentenceC


/**
 * Listing 11.2 A Singleton in Scala
* only two words
*/
object MySingleton


/// 11.2 Executable object

// Listing 11.3 Hello World!
// See: ./lesson11/src/main/scala//HelloWorld.scala


/// 11.3 Companion object

// Listing 11.4 The most talkative robot

/** The class Robot3 */
abstract class Robot3(name: String) {
    def welcome: String
}

/** The companion object of Robot3 */
object Robot3 { 
    /** Print message of most talkative Robot3 */
    def mostTalkative(r1: Robot3, r2: Robot3): Robot3 = { 
        val r1Size = r1.welcome.length 
        val r2Size = r2.welcome.length 
        if (r1Size >= r2Size) r1 else r2
    }
}

val tom3 = new Robot3("Tom") {   // An anonymous class?
    def welcome: String = Vocabulary.sentenceA
}

val alice3 = new Robot3("Alice") {
    def welcome: String = Vocabulary.sentenceB
}

Robot3.mostTalkative(tom3, alice3).welcome

tom3.welcome
alice3.welcome


/// 11.4 The apply method

// Listing 11.5 The class Person and its companion object

class Person(val name: String, val age: Int)

// Companion object
object Person {

    def apply(p1: Person, p2: Person): Person = 
        val name = s"Son of ${p1.name} and ${p2.name}"
        val age = 0
        new Person(name, age)

    def apply(name: String): Person = new Person(name, 0)

    def apply(age: Int): Person = new Person("Mr. Unknown", age)
}

val tom = new Person("Tom", 25)
val alice = new Person("Alice", 23)

val baby1 = Person.apply(tom, alice)
val baby2 = Person(tom, alice)  // syntax sugar


// You can omit the new operator

class Test(n: Int)
object Test

val test1 = new Test(1)
// works in Scala 3
val test2 = Test(2)
