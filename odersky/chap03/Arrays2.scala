// How array calls are translated into method calls in Scala
// .update .apply .to
// Equivalent code from Ex1

object Arrays2 {
  def main(args: Array[String]): Unit = {
    val greetStrings = new Array[String](3)

    greetStrings.update(0, "Hello")
    greetStrings.update(1, ", ")
    greetStrings.update(2, "world!\n")

    for i <- 0.to(2) do
      print(greetStrings.apply(i))
    println()
  }
}
