// Step 9. Use tuples

object Tuples1 {
  def main(args: Array[String]): Unit = {
    // Listing 3.4 · Creating and using a tuple.
    val pair = (99, "Luftballons")
    val num = pair(0)   // type Int, value 99
    val what = pair(1)  // type String, value "Luftballons"
    println("Number = [" + num + "], What = [" + what + "]")
  }
}
