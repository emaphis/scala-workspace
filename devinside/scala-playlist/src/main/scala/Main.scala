object Main {
    def main(args: Array[String]): Unit = {
        println()

        {
            lazy val myFavoriteNumber = {
                println("Line 7")
                1337 
            }
            
            println(s"First time: $myFavoriteNumber")
            println(s"Last time: $myFavoriteNumber")
        }
        
        println()
    }
}
