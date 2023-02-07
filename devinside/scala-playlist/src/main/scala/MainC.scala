
object MainC {
  def mainC(args: Array[String]): Unit = {
    println("-" * 50)
    
    {
      def signedBits(n: Long): Int =
        unsignedBits(n) + 1

      def unsignedBits(n: Long): Int =
        n.toBinaryString.size

      def rendered(`type`: String, min: Long, max: Long, bits: Int): String = {
        val bytes = bits / 8
        val renderedBytesWith = if(bytes == 1) "byte  with" else "bytes with"

        s"${`type`}\thas $bits\t binary digits (bits), which is $bytes $renderedBytesWith \tpossible values: $min .. $max"
      }

      def renderedSigned(`type`: String, min: Long, max: Long): String =
        rendered(`type`, max, min, signedBits(max))
      
      def renderedUnsigned(`type`: String, min: Long, max: Long): String =
        rendered(`type`, max, min, unsignedBits(max))
      
      def renderedFloating(`type`: String, min: Double, max: Double): String =
        s"${renderedFirstHalf(`type`)} $min .. $max"

      def renderedFirstHalf(`type`: String): String =
        s"${`type`}\t\t\t\t\t\t\t\tpossible values:"
            
      
      println(renderedSigned("Byte", Byte.MinValue, Byte.MaxValue))
      
      println(renderedSigned("Short", Short.MinValue, Short.MaxValue))
      println(renderedUnsigned("Char", Char.MinValue, Char.MaxValue))
      
      println(renderedSigned("Int", Int.MinValue, Int.MaxValue))
      println(renderedSigned("Long", Long.MinValue, Long.MaxValue))

      println(renderedFloating("Float", Float.MinValue, Float.MaxValue))
      println(renderedFloating("Double", Double.MinValue, Double.MaxValue))
      
      println(s"${renderedFirstHalf("Boolean")} ${true} and ${false}")

      println(s"${renderedFirstHalf("Unit")} {} or ${()}")



      def unsignedBits2(n: Long): Int = {
        @scala.annotation.tailrec
        def loop(x: Long, accu: Int): Int =
          if (x <= 1)
              1 + accu
          else loop(
              x = x / 2,
              accu = 1 + accu
            )

        loop(n, 0)
      }

      val uns1 = unsignedBits2(5)

      def toBinary(n: Long): String = {
        @scala.annotation.tailrec
        def loop(x: Long, accu: String): String =
          if (x <= 1)
             (x % 2).toString + accu
          else loop(
              x = x / 2,
              accu = (x % 2).toString() + accu
            )

        loop(n, "")
      }
      val bin1 = toBinary(10)

    }
    
    println("-" * 50)
  }
}
