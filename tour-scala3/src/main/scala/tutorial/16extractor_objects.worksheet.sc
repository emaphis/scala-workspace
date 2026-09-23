// Extractor Objects
// An extractor object is an object with an unapply method.
// he unapply takes an object and tries to give back the arguments.

import scala.util.Random

object CustomerID:

  def apply(name: String) = s"$name--${Random.nextLong()}"

  def unapply(customerID: String): Option[String] =
    val stringArray: Array[String] = customerID.split("--")
    if stringArray.tail.nonEmpty then Some(stringArray.head) else None


val customer1ID = CustomerID("Sukyoung")  // Sukyoung--23098234908

customer1ID match
  case CustomerID(name) => println(name)
  case _ => println("Could not extract a CustomerID")

val customer2ID = CustomerID("Nico")
val CustomerID(name) = customer2ID.runtimeChecked
println(name)

val CustomerID(name2) = "--asdfasdfasdf".runtimeChecked


