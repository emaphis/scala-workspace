// Chapter 7
// Built-in Control Structures
// 7.5 Match expressions

package chap07

object Match {

  // Listing 7.14 · A match expression with side effects.
  def match1(args: Array[String]): Unit =
    val firstArg = if !args.isEmpty then args(0) else ""

    firstArg match
      case "salt" => println("pepper")
      case "chips" => println("salsa")
      case "eggs" => println("bacon")
      case _  => println("huh?")


  // Listing 7.15 · A match expression that yields a value.
  def match2(args: Array[String]): Unit =
    val firstArg = if !args.isEmpty then args(0) else ""

    val companion =
      firstArg match
        case "salt" => "pepper"
        case "chips" => "salsa"
        case "eggs"  => "bacon"
        case _  => "huh?"

    println(companion)

  @main def run(): Unit =
    Match.match1(Array())
    Match.match1(Array("salt"))
    Match.match1(Array("eggs"))

    Match.match2(Array("foo"))
    Match.match2(Array("chips"))
}
