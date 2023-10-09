// Lesson 7 - Classes and Subclasses to 
//            Represent the World


/// 7.1 Class

// Listing 7.1  The class Robot
class Robot1(name: String)

val tom1 = new Robot1("Tom")
val john1 = new Robot1("John")


// Listing 7.2 The class Robot: name as val
class Robot2(val name: String)

val tom2 = new Robot2("Tom")
val john2 = new Robot2("John")

// val make the parameter accessable.
tom2.name
john2.name


// Listing 7.3 The class Robot: name with a default value
class Robot3(val name: String = "Unknown")

val tom3 = new Robot3("Tom")
val john3 = new Robot3("John")
val noName = new Robot3

tom3.name
john3.name
noName.name


// Listing 7.4 The class Robot: a greeting functionality
class Robot4(val name: String = "Unknown") {
    def welcome(n: String) = s"Welcome $n! My name is $name"
}

val tom4 = Robot4("Tom")
tom4.welcome("Martin")


/// 7.2 Subclass

// Listing 7.5 Italian and English robots
class Robot5(val name: String = "Unknown") {
    def welcome(n: String) = s"Welcome $n! my name is $name"
}

class ItalianRobot5(name: String) extends Robot5(name) {
    override def welcome(n: String) =
        s"Benvenuta $n! Il nio name e' $name"
}

class EnglishRobot5(name: String, country: String) extends Robot5(name) {
    override def welcome(n: String) =
        s"Welcome $n, I am $name from the country of $country!"
}


/// 7.3 Abstract class

// Listing 7.6 The abstract class Robot 
abstract class Robot6(name: String) {
    def welcome(n: String): String
}

// Robot6 is abstract; it cannot be instantiated
//val xxx = new Robot6("Wont Work")

// class MyRobot6 needs to be abstract, since def welcome(n: String): String
// in class Robot6 in class MdocApp is not defined 
//class MyRobot6(name: String) extends Robot6(name)

class MyRobot6(name: String) extends Robot6(name) {
    override def welcome(n: String) =
        s"Welcome $n! My name is $name"
}

val joan: Robot6 = new MyRobot6("Joan")
joan.welcome("Charley")
