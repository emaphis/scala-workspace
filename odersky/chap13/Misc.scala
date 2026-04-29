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


  def main(args: Array[String]): Unit = {
    val v = Var("x")
    val op = BinOp("+", Num(1), v)
    println(op)

    val op2 = UnOp("-", UnOp("-", v))
    println(op2)

    println("Simplify op: " + simplifyTop(op))
    println("Simplify op2: " + simplifyTop(op2))

  }
}
