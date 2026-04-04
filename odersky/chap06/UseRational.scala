package chap06

import chap06.Rational
import scala.language.implicitConversions

// Chapter 6 - Functional Objects

@main def run(): Unit =
  println(new Rational(1, 3))
  println(new Rational(5, 7))
  
  val unit = Rational(1, 1)
  println(s"unit = $unit")

  //val bad = Rational(5, 0)  // throws an exception

  val oneHalf = Rational(1, 2)
  val twoThirds = Rational(2, 3)
  val sum = oneHalf + twoThirds
  println("oneHalf [" + oneHalf + "]")
  println("twoThirds [" + twoThirds + "]")
  println("sum [" + sum + "]")
  println("sum.numerator [" + sum.numerator + "]")
  println("sum.denominator [" + sum.denominator + "]")
  println("oneHalf.lessThan(twoThirds) [" + oneHalf.lessThan(twoThirds) + "]")
  println("oneHalf.max(twoThirds) [" + oneHalf.max(twoThirds) + "]")

  val three = Rational(3)
  println(s"three = [$three]")

  val elevenSevenths = Rational(66, 42)  // should be reduced to 11/7
  println(s"elevenSevenths = $elevenSevenths")

  val x = new Rational(1, 2)
  val y = new Rational(2, 3)
  println("x [" + x + "]")
  println("y [" + y + "]")
  println("x + y [" + (x + y) + "]")
  println("x.+(y) [" + (x.+(y)) + "]")
  println("x + x * y [" + (x + x * y) + "]")
  println("(x + x) * y [" + ((x + x) * y) + "]")
  println("x + (x * y) [" + (x + (x * y)) + "]")
  println("x * x [" + (x * x) + "]")
  println("x * 2 [" + (x * 2) + "]")

  implicit def intToRational(x: Int): Rational = new Rational(x)

  val r = new Rational(2, 3)
  println("2 * r [" + (2 * r) + "]")

  val num2 = (oneHalf / 7) + (1 - twoThirds)
  println("num2 = " + num2)
