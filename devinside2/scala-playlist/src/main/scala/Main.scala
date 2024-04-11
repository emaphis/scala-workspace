// Part 3 - Exploring is the new learning!
// scopes val, lazy val, def, var
object Main {

    def mainB(args: Array[String]): Unit = {
        println()

        {
            val myFavouriteNumber = {
                println("Line 10")
                1337
            }

            println(s"First time $myFavouriteNumber")  // executed once
            println(s"Second time $myFavouriteNumber") // but printed twice
            println()

            def myFavouriteNumber2 = {
                println("Line 19")
                1337
            }

            println(s"First time $myFavouriteNumber2")
            println(s"Second time $myFavouriteNumber2")  // executed twice
            println()

            lazy val myFavouriteNumber3 = {
                println("Line 29")
                1337
            }

            println(s"First time $myFavouriteNumber3")  // executed once
            println(s"Second time $myFavouriteNumber3") // but printed twice
            println()

            var myFavouriteNumber4 = {
                println("Line 29")
                1337
            }

            println(s"First time $myFavouriteNumber4")  // executed once
            println(s"Second time $myFavouriteNumber4") // but printed twice
            println()

            myFavouriteNumber4 = {
                println("Line 48")
                1313
            }

            println(s"First time $myFavouriteNumber4")  // executed once
            println(s"Second time $myFavouriteNumber4") // but printed twice
        }
        println()
    }
}

// val      is a value (stored in memory)
// def      is a definition (ontlh the computation is stored)
// lazy val is value that behaves first like def then a val
// var      is a memory location that store vals and allows them to be updated later