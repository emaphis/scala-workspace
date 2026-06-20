
object UseChecksumAccumulator {
  def main(args: Array[String]): Unit = {
    val acc = new ChecksumAccumulator
    val csa = new ChecksumAccumulator
    // acc.sum = 3  // wont compile, sum is private
    //acc = new ChecksumAccumulator // doesn't compile

    val calc = new ChecksumAccumulator
    calc.add(2)

    println("calc.checksum [" + calc.checksum() + "]")

    val chk1 = ChecksumAccumulator.calculate("Every value is an object.")
    println("check = " + chk1)
  }
}
