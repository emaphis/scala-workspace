// Chapter 13
// Pattern Matching

// 13.1 A simple example

trait Expr
case class Var(name: String) extends Expr
case class Num(number: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

// the compiler  adds a factory method with the name of the class.

val v = Var("x")
val op = BinOp("+", Num(1), v)

// the compiler all arguments in the parameter list
// of a case class implicitly get a val prefix,
v.name
op.left

// the compiler adds “natural” implementations of methods toString,
// hashCode, and equals to your class.

op.toString
op.right == Var("x")

// the compiler adds a copy method to your class for making modified
// copies.

op.copy(operator = "-")

// Listing 13.2 · The simplifyTop function, which does a pattern match.
def simplifyTop(expr: Expr): Expr =
  expr match
    case UnOp("-", UnOp("-", e)) => e // Double negative
    case BinOp("+", e, Num(0)) => e   // Adding zero
    case BinOp("*", e, Num(0)) => e   // Multiplying by one
    case _  => expr

simplifyTop(UnOp("-", UnOp("-", Var("x"))))

// Listing 13.3 · A pattern match with an empty “default” case.
def checkBinary(expr: Expr): Unit =
  expr match
    case BinOp(op, left, right) =>
      println(s"$expr is a binary operation")
    case _ =>

val varExpr = Var("var")
val zeroExpr = Num(0)
val binopExpr = BinOp("=", varExpr, varExpr)
val unopExpr = UnOp("abs", Num(3))

checkBinary(varExpr)
checkBinary(binopExpr)

// Listing 13.4 · A pattern match with wildcard patterns.
def checkBinary2 (expr: Expr): String =
  expr match
    case BinOp(_, _, _) =>  s"$expr is a binary operation"
    case _  => "Its's something else"

checkBinary2(varExpr)
checkBinary2(binopExpr)

// Listing 13.5 · A pattern match with constant patterns.
def describe(x: Any): String =
  x match
    case 5 => "five"
    case true  => "truth"
    case "hello" => "hi"
    case Nil => "the empty list"
    case _ => "Something else"

describe(5)
describe(true)
describe("hello")
describe(Nil)
describe(List(1,2,3))

