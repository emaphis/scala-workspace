package chap06

import scala.annotation.tailrec
// Chapter 6 - Functional Objects

// 6.1 A specification for class Rational
// Listing 6.1 · Rational with fields.

class Rational(n: Int, d: Int):
  require(d != 0)
  
  private val g = gcd(n.abs, d.abs)
  val numerator: Int = n / g
  val denominator: Int = d / g

  /** whole number constructor */
  def this(n: Int) = this(n, 1)  // auxiliary constructor
  
  override def toString: String = s"$numerator/$denominator"
  
  def + (that: Rational): Rational =
    Rational(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator
    )

  def + (i: Int): Rational =
    Rational(numerator + i * denominator, denominator)

  def - (that: Rational): Rational =
    Rational(
      numerator * that.denominator - that.numerator * denominator,
      denominator * that.denominator
    )

  def - (i: Int): Rational =
    Rational(numerator - i * denominator, denominator)

  def * (that: Rational): Rational =
    Rational(numerator * that.numerator, denominator * that.denominator)

  def *(i: Int): Rational =
    Rational(numerator * i, denominator)

  def /(that: Rational): Rational =
    Rational(numerator * that.denominator, denominator * that.numerator)

  def /(i: Int): Rational =
    Rational(numerator, denominator * i)

  def lessThan(that: Rational): Boolean =
    this.numerator * that.denominator < that.numerator * this.denominator
  
  def max(that: Rational): Rational =
    if this.lessThan(that) then that else this

  @tailrec
  private def gcd(a: Int, b: Int): Int =
    if b == 0 then a else gcd(b, a % b)
