// Queck Checks for Lesson 14

/*
Quick Check 14.1 Consider the function objInfo shown in listing 14.3. Guess the
type and value that the function returns for the following inputs. Use the REPL to validate your hypotheses.
     objInfo(-1)     - "-1"
     objInfo(true)   -  "true" 
     objInfo(200)    - "200 is a positive integer"
     objInfo(200.00) - "200.0 is a double"
     objInfo("ping") - "pong"
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


/*
Quick Check 14.2 You now have four possible implementations for the sealed trait
Currency. Fix the function exchangeRateUSD so that you no longer see the match-not
exhaustive warning when compiling your code.
*/

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
