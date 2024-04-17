// Part 9 - Ways of Creation - Part 1 - Literals
object Main09 {
  def main09(args: Array[String]): Unit = {
    println("~" * 50)

    {
      // val a: Byte = 127   // 127
      // val a: Byte = 0x7F  // 127
      // val a: Byte = 0x80  // 128 - type missmatch

      // val b: Long = Long.MaxValue  // 9223372036854775807
      // val b: Long = 9223372036854775807L

      // val c: Char = 'A'
      // val c: Char = 65       // A
      // val c: Char = 0x41     // A
      // val c: Char = 0x0041   // A
      // val c: Char = '\u0041' // A
      // val c: Char = '\uffff'
      // println(Char.MaxValue: Int)

      // val d: Float = 0.5f
      // val d: Float = 0.5F

      // val e: Double = 0.5
      // val e: Double = 0.5d
      // println(0.5e0)

      // println(true)
      // println(false)

      // val f: String = "hello world"
      // val f: String = """hello
      // world"""

      // val f: String =
      //    """#hello
      //    #world""".stripMargin('#')
      // val f: String =
      //    """|hello
      //       |world""".stripMargin

      // val g: Symbol = 'hi

      // val h: Char = '\n'  // form feed
      // val h: String = "hello\nworld"  // line feed
      // val h: String = "hello\nworld"  // line feed
      // val h: String = "hello\fworld"  // form feed
      // val h: String = "hello\tworld"  // horizintal tab
      // val h: String = "hello\nworld"  // line feed

      // val i: Int => Int = x => x + 1
      // val i: Int => Int = _ + 1

      // val i: (Int, Int) => Boolean =
      //    (left, right) => left ==  right
      // val i: (Int, Int) => Boolean =
      //     _ == _

      def now: String = {
        val formatter =
          java
            .time
            .format
            .DateTimeFormatter
            .ofPattern("HH:mm:ss")
        java
          .time
          .LocalDateTime
          .now
          .format(formatter)
      }

      def inOneLine(in: String): String = {
        val clearLine = "\u001b[2K"
        val carriageReturn = "\r"

        clearLine + carriageReturn + in
      }

      var i = 0
      while (i < 5) {
        Thread.sleep(1000)
        print(inOneLine(now))
        i += 1
      }

      println()

      // println("Hello Main 9a")
    }

    println("~" * 50)
  }
}
