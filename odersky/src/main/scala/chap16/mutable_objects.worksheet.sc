// Chapter 16
// Mutable Objects

// 16.1 What makes an object mutable?

// When you invoke a method or dereference a field on some purely functional
// object, you will always get the same result.

val cs = List('a', 'b', 'c')

cs.head


// Listing 16.1 · A mutable bank account class.
class BankAccount:

  private var bal: Int = 0
  def balance: Int = bal

  def deposit(amount: Int): Unit =
    require(amount > 0)
    bal += amount

  def withdraw(amount: Int): Boolean =
    if amount > bal then false
    else
      bal -= amount
      true

val account = new BankAccount
account.deposit(100)
account.withdraw(80) // true
account.withdraw(80)


class Keyed:
  def computeKey: Int = 5

// Can be faster because results are stored in a chache
// for later use.
class MemoKeyed extends Keyed:
   private var keyCache: Option[Int] = None

   override def computeKey: Int =
     if !keyCache.isDefined then
       keyCache = Some(super.computeKey)
     keyCache.get

val memo = MemoKeyed()
memo.computeKey

// 16.2 Reassignable variables and properties

object Listing16_2:
  class Time:
    var hour = 12
    var minute = 0

val time2 = Listing16_2.Time()
time2.hour
time2.minute
time2.hour = 13
time2.minute = 14
time2.hour
time2.minute

// Listing 16.3 · How public vars are expanded into getter and setter methods

object Listing16_3:
  class Time:
    private var h = 12
    private var m = 0

    def hour: Int = h
    def hour_=(x: Int): Unit =
      h = x

    def minute: Int = m
    def minute_=(x: Int): Unit =
      m = x

val time3 = Listing16_3.Time()
time3.hour
time3.minute
time3.hour = 13
time3.minute = 14
time3.hour
time3.minute

// Listing 16.4 · Defining getter and setter methods directly
object Listing16_4:
  class Time:
    private var h = 12
    private var m = 0

    def hour: Int = h
    def hour_=(x: Int): Unit =
      require(0 <= x && x < 24)
      h = x

    def minute: Int = m
    def minute_=(x: Int): Unit =
      require(0 <= x && x < 60)
      m = x

val time4 = Listing16_4.Time()
time4.hour
time4.minute
time4.hour = 13
time4.minute = 14
time4.hour
time4.minute

try {
  time4.minute = 61
} catch {
  case ex: IllegalArgumentException => println("caught exception")
}

// Listing 16.5 · Defining a getter and setter without an associated field.
import scala.compiletime.uninitialized

class Thermometer:
  var celsius: Float = uninitialized

  def fahrenheit = celsius * 9 / 5 + 32
  def fahrenheit_=(f: Float) =
    celsius = (f - 32) * 5 / 9

  override def toString =
    s"${fahrenheit}F/${celsius}C"


val t = new Thermometer
t
t.celsius = 100
t
t.fahrenheit = -40
t

// 16.3 Case study: Discrete event simulation
// -  Circuit Simulation
// *** Running the simulator

import chap16.simulation.CircuitSimulation

object MySimulation extends CircuitSimulation:
  def InverterDelay = 1
  def AndGateDelay = 3
  def OrGateDelay = 5

import MySimulation.*

val input1, input2, sum, carry = new Wire
probe("sum", sum)
probe("carry", carry)

halfAdder(input1, input2, sum, carry)
// TODO: fix
input1 setSignal true
//run()

//input2 setSignal true
//run()
