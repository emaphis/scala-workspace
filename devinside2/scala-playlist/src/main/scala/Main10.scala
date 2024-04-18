// Part 10 - Ways of Creation - Part 2 - Composition
object Main10 {
  def main(args: Array[String]): Unit = {
    println("~" * 50)

    {
        val a: Byte = 1  // 1
        val b: Short = a // 2
        val c: Int = b   // 4
        val d: Long = c  // 8

        val e: Float = d  // 4
        val f: Double = e // 8

        println(a)
        println(b)
        println(c)
        println(d)
        println(e)
        println(f)
        println()

        def a1: Byte = b1.toByte  // 1
        def b1: Short = c1.toShort // 2
        def c1: Int = d1.toInt   // 4
        def d1: Long = e1.toLong  // 8

        def e1: Float = f1.toFloat  // 4
        def f1: Double = Double.MaxValue // 8

        println("Double\t" + f1)
        println("Float\t" + e1)
        println("Long\t" + d1)
        println("Int\t" + c1)
        println("Short\t" + b1)
        println("Byte\t" + a1)
        println()

        println(3 + 5)
        println(3.-(5))
        println(3 * 5)
        println(3 / 5)
        println(3 % 5)
        println()


    }

    println("~" * 50)
  }
}
