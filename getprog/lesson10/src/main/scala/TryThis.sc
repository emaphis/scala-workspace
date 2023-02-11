// Lesson 10  - Try This

/*
TRY THIS Define a class Employee with three values: a name of type String, an
age of Int, and a salary of type Double. While its name should be publicly acces￾sible, its age should be visible only from its class and subclasses, and its salary
should be private.
*/

class Employee (
    val name: String,
    protected val age: Int,
    private val salary: Double) {}
