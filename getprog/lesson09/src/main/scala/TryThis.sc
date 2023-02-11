// Lesson 9 - Try This

/*
TRY THIS Create a package in an sbt project, called my.areas, that contains
two files: Circle.scala and Square.scala.
*/

import  my.areas.{Square, Circle}

val sqArea = new Square().area(10)
val crArea = new Circle().area(10)

println(sqArea)
println(crArea)
