// Part 5 - Introduction to Type Systems

object Main5{

    def main(args: Array[String]): Unit = {
        println("~" * 50)

        {
            type Conditonal = Boolean

            // type declarations are optional
            val a: Int = 1337
            val b: Conditonal = true
            val c: Char = 't'
            val d: String = "true"
            val e: Unit = {}
            def ee {}  // Wut?
            val f: Any = if (b) 10 else "not 10"
            var gg: Int = 13
            gg = 13 + 1

            println(a)
            println(b)
            println(c)
            println(d)
            println(e)
            println(f)
            println(gg)
        }

        println("~" * 50)
    }
}
