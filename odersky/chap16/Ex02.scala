// Chapter 16
// Mutable Objects

// Listing 16.1 · A mutable bank account class

package chap16

// Listing 16.1 · A mutable bank account class.

class BankAccount:

  private var bal: Int = 0

  def deposit(amount: Int): Unit =
    require(amount > 0)
    bal += amount

  def withdraw(amount: Int): Boolean =
    if amount > bal then false
    else
      bal -= amount
      true


object Ex02:
  def main(args: Array[String]): Unit = {
    val account = BankAccount()
    println("account deposit 100 [" + (account deposit 100) + "]")
    println("account withdraw 80 [" + (account withdraw 80) + "]")
    println("account withdraw 80 [" + (account withdraw 80) + "]")
  }
