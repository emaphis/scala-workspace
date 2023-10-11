// Try This - Lesson 16

/*
    TRY THIS Implement a function to parse a string into an integer. If you cannot
    parse it, return its length instead. HINT: Use the toInt function on an instance
    of String.
*/

def parseToInt (str: String): Int =
    try
        str.toInt
    catch
        case ex: NumberFormatException =>
            str.length

parseToInt("1")   == 1
parseToInt("3")   == 3
parseToInt("one") == 3
