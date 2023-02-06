object Main {
    def main(args: Array[String]): Unit = {
        println("-" * 50)

        {
            val a: Int = 1338
            val b: Boolean = true
            val c: Char   = 't'
            val d: String = "true"
            val e: Unit  = {}
            val f: Any  = if (true) 10 else "not 10"
            
            println(a)
            println(b)
            println(c)
            println(d)
            println(e)
            println(f)
        }

        println("-" * 50)
    }
} 
