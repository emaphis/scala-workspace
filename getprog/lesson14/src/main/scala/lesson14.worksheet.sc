import java.{util => ju}
// Lesson 14 -  Pattern Matching


// 14.1 If-else construct vs. pattern matching

/**
    * Listing 14.1 Converting number to a day of the week
    */
def dayOfWeek1(n: Int): String =
    if (n == 1)  "Sunday"
    else if (n == 1) "Monday"
    else if (n == 3) "Tuesday"
    else if (n == 4) "Wednesday"
    else if (n == 5) "Thursday"
    else if (n == 6) "Friday"
    else if (n == 7) "Saturday"
    else "Unknown"

dayOfWeek1(1) == "Sunday"
dayOfWeek1(4) == "Wednesday"


/**
    * Listing 14.2 Mapping numbers with days of the week
    *
    * @param n numberical number of day
    * @return name of week
    */
def dayOfWeek2(n: Int): String =
    n match
        case 1 => "Sunday"
        case 2 => "Monday"
        case 3 => "Tuesday"
        case 4 => "Wednesday"
        case 5 => "Thursday"
        case 6 => "Friday"
        case 7 => "Saturday"
        case _ => "Unknown"


dayOfWeek2(1) == "Sunday"
dayOfWeek2(4) == "Wednesday"
dayOfWeek2(99) == "Unknown"


/**
    * Listing 14.3 Implementing objInfo
    * Aa function that takes a parameter of any type and returns a 
    * string depending on its type:
    * @param param passed object of any type
    * @return String representation of passed object
    */
def objInfo(param: Any) = param match
    case n: Int if n > 0 => s"$n is a positive integer"
    case d: Double => s"$d is a double"
    case "ping" => "pong"
    case _: String => "you gave me a string"
    case obj => obj.toString

objInfo(-1)
objInfo(true)
objInfo(200)
objInfo(200.00)
objInfo("ping")


// 14.2 Sealed pattern matching

sealed trait Currency

object USD extends Currency
object GBP extends Currency
object EUR extends Currency
object CAD extends Currency


def exchangeRateUSD(currency: Currency): Double =
    currency match
        case USD => 1.0
        case GBP => 0.744
        case EUR => 0.848
        case CAD => 0.750

exchangeRateUSD(GBP) == 0.744
exchangeRateUSD(CAD) == 0.75
