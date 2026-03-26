// Type less do more

// New Scala 3 Syntax—Optional Braces

class Foo:
  def uppify(s: String): String =
    s.toUpperCase
end Foo  // optional

val up = Foo()
up.uppify("this is a string")


val sequence = Seq("STILL", "MORE", "HELLO", "WORLD")

var i = 1
if i > 0 then
  println(sequence)
end if  // optional

while i < 10 do
  i += 1
end while

for j <- 0 to 10 do
  println(j)
end for


// Semicolons are inferred

val str = Seq("STILL", "MORE", "HELLO", "WORLD")
  .map(_.toLowerCase())
  .mkString("[", ", ", "]")


// Variable Declarations

val seq: Seq[String] = Seq("This", "is", "Scala")
val array: Array[String] = Array("This", "is", "Scala")

// Classes can be implemented by primitive types for performance reasons
class Human(val name: String, var age: Int)

val p = Human("Dean Wampler", 29)
p.name

//p.name = "Buck Trends"

p.age
p.age = 30
p.age

// Ranges

val rng1 = 1 to 10

val rng2 = 1 until 10

val rng3 = 1 to 10 by 3

(1 to 20 by 3).foreach(println)

(10 to 1 by -1).foreach(println)
