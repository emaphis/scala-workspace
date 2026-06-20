import chap06.Rational

import scala.language.implicitConversions

val unit = Rational(1, 1)

//val bad = Rational(5, 0)  // throws an exception

val oneHalf = Rational(1, 2)
oneHalf.numerator
oneHalf.denominator

val twoThirds = Rational(2, 3)

val three = Rational(3)

val elevenSevenths = Rational(66, 42)

oneHalf + twoThirds

implicit def intToRational(x: Int): Rational = new Rational(x)
(oneHalf / 7) + (1 - twoThirds)
