// Lesson 7

/* Quick Check 7.1 Create a class Person with a name of type String and an age of
   type Int—defaulted to 0. Define a method called presentYourself, for the class Per￾son; it takes no parameters, and it returns a string to communicate the name and
   age of a person. Create two instances and see what the presentYourself method
   returns for each of them: Martin is 18, and Bob is 0 years old.
*/

class Person(name: String, age: Int = 0) {
    def presentYourself =
        s"Hi, my name is $name and I am $age years old"
}

val martin = new Person("Martin", 18)
val bob = new Person("Bob")

martin.presentYourself
bob.presentYourself


/*  Quick Check 7.2 In Quick Check 7.1, you defined a class Person. Create two sub￾classes of the class Person: one to represent a teacher; the other to represent a
    student. A student should have an additional parameter to track its ID
*/

class Teacher(name: String, age: Int) extends Person(name, age)

class Student(name: String, age: Int, id: Int) extends Person(name, age)

val sue = new Teacher("Sue", 35)
val ralf = new Student("Ralf", 15, 1001)

sue.presentYourself
ralf.presentYourself


/* Quick Check 7.3 In Quick Check 7.1, you defined the class Person. Change its
implementation to force all its subclasses to implement a method called hello, which
takes one String parameter representing a name and returns another String.
*/

abstract class Person3(name: String, age: Int = 0) {
    def hello(n: String): String
}


class Teacher3(name: String, age: Int) extends Person3(name, age) {
    override def hello(n: String) =
        s"Hello $n, I am a teacher named $name"
}

class Student3(name: String, age: Int, id: Int) extends Person3(name, age) {
    override def hello(n: String) =
        s"Hi $n, I am a student named $name, I am $age years old"
}

val sue3: Person3 = new Teacher3("Sue", 35)
val ralf3: Person3 = new Student3("Ralf", 15, 1001)

sue3.hello("Joan")
ralf3.hello("Joan")
