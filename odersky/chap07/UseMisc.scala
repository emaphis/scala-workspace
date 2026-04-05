package chap07

import chap07.Misc

object UseMisc:
  def main(args: Array[String]): Unit =
    Misc.ifVariations(Array("foo.txt"))
    Misc.ifVariations(Array())

    println("gcdLoop(2, 4) [" + Misc.gcdLoop(2, 4) + "]")
    println("gcdLoop(3, 4) [" + Misc.gcdLoop(3, 4) + "]")

    Misc.whileLoop()

    println("gcd(2, 4) [" + Misc.gcd(2, 4) + "]")
    println("gcd(3, 4) [" + Misc.gcd(3, 4) + "]")
