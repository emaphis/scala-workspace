/* Part 13 - Message Passing Style & The Birth of OO */

object MainH {

  /** An Example */
  def f() = {
      
    class BankAccount(private[this] val intitialBalance: Int) {
      private[this] var _balance: Int = intitialBalance
      
      def withdraw(amount: Int): Unit =
        if (_balance >= amount) 
          _balance = _balance - amount
        else
          sys.error("Insufficient funds")

      def deposit(amount: Int): Unit =
        if (amount >= 1)
          _balance = _balance + amount
        else
          sys.error("It's only possible to deposit positive amounts")
      
      def balance: Int =
         _balance
    }

    val bankAccount1 = new BankAccount(intitialBalance = 100)
    
    bankAccount1.withdraw(10)
    println(bankAccount1.balance)
    
    bankAccount1.withdraw(15)
    println(bankAccount1.balance)
    
    bankAccount1.deposit(125)
    println(bankAccount1.balance)
    println()

    def makeTransfer(from: BankAccount, amount: Int, to: BankAccount): Unit = {
      def showBothAccount: Unit = {
        println(s"from: ${from.balance}")
        println(s"to:   ${to.balance}")
      }

      println("Before:")
      showBothAccount

      from.withdraw(amount)
      to.deposit(amount)

      println()
      println("After:")
      showBothAccount
      
      println("amount: " + amount)
    }

    val thisOne: BankAccount = new BankAccount(intitialBalance = 50)
    val thatOne: BankAccount = new BankAccount(intitialBalance = 15)

    makeTransfer(
      from = thisOne,
      amount = 20, 
      to = thatOne
    )

    println("Hello")
  }

  /** main program */
  def mainH(args: Array[String]): Unit = {
    println("-" * 50)
    f()
    println("-" * 50)
  } 
}
