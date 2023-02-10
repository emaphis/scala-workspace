@main def hello: Unit =
  val machine = new VendingMachine()

  println(machine.buy("chocolate", 1.5))

  println(machine.chocolateBar)
  println(machine.granolaBar)

  // Let’s add two chocolate bars and one granola to the machine:
  machine.chocolateBar += 2
  machine.granolaBar += 1

  // now try again
  println(machine.buy("chocolate", 1.5))
  println(machine.buy("chocolate", 1))

  println(machine.buy("granola", 2))
  println(machine.buy("granola", 2))

  println(machine.totalMoney)
