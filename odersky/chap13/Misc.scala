// Chapter 13
// Pattern Matching

package chap13

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

  // Variable patterns

  // Listing 13.6 · A pattern match with a variable pattern
  def startsWithZero(expr: Any): String =
    expr match
      case 0 => "zero"
      case somethingElse => s"not zero $somethingElse"

  // Constructor patterns

  // Listing 13.7 · A pattern match with a constructor pattern.
  def deepMatch(expr: Expr): String =
    expr match
      case BinOp("+", e, Num(0)) => "a deep match"
      case _ => ""

  // Sequence patterns

  // Listing 13.8 · A sequence pattern with a fixed length.
  def startsWithZero1(xs: List[Int]): String =
    xs match
      case List(0, _, _) => "found it"
      case _ => ""

  // Listing 13.9 · A sequence pattern with an arbitrary length.
  def startsWithZero2(xs: List[Int]): String =
    xs match
      case List(0, _*) => "found it"
      case _ => ""

  // Tuple patterns

  // Listing 13.10 · A pattern match with a tuple pattern.
  def tupleDemo(obj: Any): String =
    obj match
      case (a, b, c) => s"matched $a$b$c"
      case _ => ""

  // Typed patterns

  // Listing 13.11 · A pattern match with typed patterns
  def generalSize(x: Any): Int =
    x match
      case s: String   => s.length
      case m: Map[_,_] => m.size
      case _   => -1

  // Listing 13.12 · Using isInstanceOf and asInstanceOf (poor style).
  def isInstance1(expr: Any): Int =
    if (expr.isInstanceOf[String]) {
      val s = expr.asInstanceOf[String]
      s.length
    }
    else 0

  // better
  def isInstance2(expr: Any): Int =
    expr match {
      case s: String =>
        s.length
      case _ => 0
    }

  // type erasure

  def isIntIntMap(x: Any): Boolean =
    x match
      case m: Map[Int, Int] => true  // cant be checked at runtime
      case _ => false

  // Arrays are checked at runtime
  def isStringArray(x: Any): String =
    x match
      case a: Array[String] => "yes"
      case _ => "no"

  // 13.3 Pattern guards

  // Listing 13.14 · A match expression with a pattern guard.
  def simplifyAdd(e: Expr): Expr =
    e match
      case BinOp("+", x, y) if x == y =>
        BinOp("*", x, Num(2))
      case _ => e
  
  // 13.4 Pattern overlaps

  // Listing 13.15 · Match expression in which case order matters.
  def simplifyAll(expr: Expr): Expr =
    expr match
      case UnOp("-", UnOp("-", e)) =>
        simplifyAll(e)
      case BinOp("+", e, Num(0)) =>
        simplifyAll(e)
      case BinOp("*", e, Num(1)) =>
        simplifyAll(e)
      case UnOp(op, e) =>
        UnOp(op, simplifyAll(e))
      case BinOp(op, l, r) =>
        BinOp(op, simplifyAll(l), simplifyAll(r))
      case _ => expr


  def main(args: Array[String]): Unit = {
    val v = Var("x")
    val op1 = BinOp("+", Num(1), v)
    println(op1)

    val op2 = UnOp("-", UnOp("-", v))
    println(op2)

    println("Simplify op1: " + simplifyTop(op1))
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

    println(startsWithZero(0))
    println(startsWithZero("Any Thing"))

    println(deepMatch(zeroExpr))
    println(deepMatch(BinOp("+", varExpr, zeroExpr)))

    println(startsWithZero1(List(0, 1, 2)))
    println(startsWithZero1(List(2, 3, 4)))

    println(startsWithZero2(List(0)))
    println(startsWithZero2(List(0, 1, 2)))
    println(startsWithZero2(List(2, 3, 4)))
    println(startsWithZero2(List(1)))

    println(tupleDemo(("a ", 3, "-tuple")))

    println(generalSize("abc"))
    println(generalSize(Map(1 -> 'a', 2 -> 'b')))
    println(generalSize(math.Pi))

    println(isInstance2("foo"))
    println(isInstance2(333))

    println(isIntIntMap(Map(1 -> 1)))
    println(isIntIntMap(Map("abc" -> "abc")))  // oops

    println(isStringArray(Array("abc")))
    println(isStringArray(Array(1, 2, 3)))

    println(simplifyAdd(BinOp("+", Num(4), Num(4))))
  }
}
