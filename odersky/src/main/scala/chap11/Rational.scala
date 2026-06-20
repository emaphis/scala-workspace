// Chapter 11
// Traits

// 11.2 Thin versus rich interfaces
// Copied from Chapter 6 - Functional Objects

package chap11

import scala.annotation.tailrec

class Rational(n: Int, d: Int) extends Ordered[Rational]:
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numerator: Int = n / g
  val denominator: Int = d / g

  /** whole number constructor */
  def this(n: Int) = this(n, 1)  // auxiliary constructor

  override def toString: String = s"$numerator/$denominator"

  // Abstract method from Ordered trait
  override def compare(that: Rational): Int =
    (this.numerator * that.denominator) - (that.numerator * this.denominator)

  // Comparison operators
  // Redundant because of the inclusion of `trait Ordered`
  //def <(that: Rational): Boolean =
  //  this.numerator * that.denominator < that.numerator * this.denominator
  //def >(that: Rational): Boolean = that < this
  //def <=(that: Rational): Boolean = (this < that) || (this == that)
  //def >=(that: Rational): Boolean = (this > that) || (this == that)


  def +(that: Rational): Rational =
    Rational(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator
    )

  def +(i: Int): Rational =
    Rational(numerator + i * denominator, denominator)

  def -(that: Rational): Rational =
    Rational(
      numerator * that.denominator - that.numerator * denominator,
      denominator * that.denominator
    )

  def -(i: Int): Rational =
    Rational(numerator - i * denominator, denominator)

  def *(that: Rational): Rational =
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

end Rational
