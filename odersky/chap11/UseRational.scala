// Chapter 11
// Traits

// 11.2 Thin versus rich interfaces

package chap11

@main def run(): Unit =
  val half = new Rational(1, 2)
  val third = new Rational(1, 3)
  println(half < third) // false
  println(half > third) // true
  
