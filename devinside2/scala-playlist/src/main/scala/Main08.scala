// Part 8 - Primitive Types on the JVM

object Main08 {

  def part1() {
    val a: Byte = 1 // 1 Byte

    val b: Short = 1 // 2 Bytes
    val c: Char = 'c' // 2 Bytes

    val d: Int = 1 // 4 Bytes
    val e: Long = 1 // 8 Bytes

    val f: Float = 0.1f // 4 Bytes
    val g: Double = 0.1 // 4 Bytes

    val h: Boolean = true

    val i: Unit = {} // ()

    println(a)
    println(b)
    println(c)
    println(d)
    println(e)
    println(f)
    println(g)
    println(h)
    println(i)
  }

  def main08(args: Array[String]): Unit = {
    println("~" * 50)

    {
      def signedBits(n: Long): Int =
        unsignedBits(n) + 1

      def unsignedBits(n: Long): Int =
        n.toBinaryString.size

      def rendered(`type`: String, min: Long, max: Long, bits: Int): String = {
        val bytes = bits / 8

        s"${`type`}\thas $bits\t binary digits (bits), which is $bytes bytes with \tprossible values $min .. $max" 
      }

      def renderedSigned(`type`: String, min: Long, max: Long): String =
        rendered(`type`, min, max, signedBits(max))

      def renderedUnsigned(`type`: String, min: Long, max: Long): String =
        rendered(`type`, min, max, unsignedBits(max))


      def renderedFloating(`type`: String, min: Double, max: Double): String =
        s"${renderedFirstHalf(`type`)} $min .. $max"

      def renderedFirstHalf(`type`: String): String =
        s"${`type`}\t\t\t\t\t\t\t\tpossible values:"

      println(renderedSigned("Byte", Byte.MinValue, Byte.MaxValue))
      println()

      println(renderedSigned("Short", Short.MinValue, Short.MaxValue))
      println(renderedUnsigned("Char", Char.MinValue, Char.MaxValue))
      println()

      println(renderedSigned("Int", Int.MinValue, Int.MaxValue))
      println(renderedSigned("Long", Long.MinValue, Long.MaxValue))
      println()  

      println(renderedFloating("Float", Float.MinValue, Float.MaxValue))
      println(renderedFloating("Double", Double.MinValue, Double.MaxValue))
      println()

      println(s"${renderedFirstHalf("Boolean")} ${true} and ${false}")
      println()

      println(s"${renderedFirstHalf("Unit")} {} or ${()}")
    }

    println("~" * 50)
  }
}
