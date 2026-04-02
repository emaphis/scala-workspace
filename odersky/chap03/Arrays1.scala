import java.math.BigInteger
// Step 7. Parameterize arrays with types

object Arrays1 {
  def main(args: Array[String]): Unit = {
    val big = new BigInteger("12345")
    println("big [" + big + "]")

    val greetString = new Array[String](3)

    greetString(0) = "hello"
    greetString(1) = ", "
    greetString(2) = "world\n"

    for i <- 0 to 2 do
      print(greetString(i))
    println()

    // More concise method of creating Arrays
    val numNames = Array("zero", "one", "two")
    println("numNames.toList [" + numNames.toList + "]")

    // This is sugar for .apply
    val numNames2 = Array.apply("zero", "one", "two")
    println("numNames2.toList [" + numNames2.toList + "]")
  }
}
