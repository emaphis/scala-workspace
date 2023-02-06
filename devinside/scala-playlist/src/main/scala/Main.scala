object Main {
    def main(args: Array[String]): Unit = {
        println("-" * 50)

        {
            val isSunnyDay = true 
            val isRainyDay = true

            def result = {
                if(isSunnyDay)
                    "I'm happy"
                else if (isRainyDay)
                    "I'm sad because it's raining"
                else
                    "I'm not sure how I feel about today"
            }
            
            println(result)
            println(FarAway.hi)
        }

        println("-" * 50)
    }
} 
