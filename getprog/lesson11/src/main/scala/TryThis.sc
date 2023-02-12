// Lesson 11

/* 
TRY THIS In listing 11.5, you added an apply method to create an instance of
a person given two existing ones. Create new functions for the class Person to
 determine the oldest between two people and
 create a person by copying the parameters of an existing one.
*/

class Person(val name: String, val age: Int)

object Person {

    def oldest(p1: Person, p2: Person): Person =
        if (p1.age > p2.age) p1 else p2


    def apply(p1: Person, p2: Person): Person = 
        val name = s"Son of ${p1.name} and ${p2.name}"
        val age = 0
        new Person(name, age)

    def apply(person: Person): Person = new Person(person.name, person.age)
}

val tom = new Person("Tom", 25)
val alice = new Person("Alice", 23)

Person.oldest(tom, alice).name

val dup = Person(tom)
dup.name
dup.age
