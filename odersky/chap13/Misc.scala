// Chapter 13
// Pattern Matching

// 13.1 A simple example

object Misc {
  // Listing 13.1 · Defining case classes.
  trait Expr
  case class Var(name: String) extends Expr
  case class Num(number: Double) extends Expr
  case class UnOp(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

  // Listing 13.2 · The simplifyTop function, which does a pattern match.
  def simplifyTop(expr: Expr): Expr =
    expr match
      case UnOp("-", UnOp("-", e)) => e // Double negative
      case BinOp("+", e, Num(0)) => e // Adding zero
      case BinOp("*", e, Num(0)) => e // Multiplying by one
      case _ => expr

  // Listing 13.3 · A pattern match with an empty “default” case.
  def checkBinary(expr: Expr): Unit =
    expr match
      case BinOp(op, left, right) =>
        println(s"$expr is a binary operation")
      case _ =>

  // 13.2 Kinds of patterns

  // Listing 13.4 · A pattern match with wildcard patterns.
  def checkBinary2 (expr: Expr): String =
    expr match
      case BinOp(_, _, _) =>  s"$expr is a binary operation"
      case _  => "Its's something else"

  // Listing 13.5 · A pattern match with constant patterns.
  def describe(x: Any): String =
    x match
      case 5 => "five"
      case true => "truth"
      case "hello" => "hi"
      case Nil => "the empty list"
      case _ => "Something else"


  def main(args: Array[String]): Unit = {
    val v = Var("x")
    val op = BinOp("+", Num(1), v)
    println(op)

    val op2 = UnOp("-", UnOp("-", v))
    println(op2)

    println("Simplify op: " + simplifyTop(op))
    println("Simplify op2: " + simplifyTop(op2))

    val varExpr = Var("var")
    val zeroExpr = Num(0)
    val binopExpr = BinOp("=", varExpr, varExpr)
    val unopExpr = UnOp("abs", Num(3))

    println(checkBinary(varExpr))
    println(checkBinary(binopExpr))

    println(checkBinary2(varExpr))
    println(checkBinary2(binopExpr))

    println(describe(5))
    println(describe(true))
    println(describe("hello"))
    println(describe(Nil))
    println(describe(List(1, 2, 3)))
  }
}
