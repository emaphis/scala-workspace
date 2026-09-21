// Named Arguments

def printName(first: String, last: String): Unit =
  println(s"$first $last")

printName("John", "Public")
printName(first = "John", last = "Public")
printName(last = "Public", first = "John")
printName("Elton", last = "John")

// Once a name parameter is used, make sure to put the rest of the parameters in proper order

def printFullName(first: String, middle: String = "Q.", last: String): Unit =
  println(s"$first $middle $last")

printFullName(first = "John", last = "Public")
printFullName("John", last = "Public")
printFullName("John", middle = "Quincy", "Public")
printFullName(last = "Public", first = "John")
//printFullName(last = "Public", "John")  // Wont compile