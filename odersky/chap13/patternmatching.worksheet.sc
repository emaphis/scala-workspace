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

//Listing 13.6 · A pattern match with a variable pattern.
def startsWithZero(expr: Any): String =
  expr match
    case 0 => "zero"
    case somethingElse => s"not zero $somethingElse"

startsWithZero(0)
startsWithZero("Any thing else")

//Variable or constant?
import math.{E, Pi}

E match
  case Pi => s"strange math? pi = $Pi"
  case _ => "Ok"

val pi = math.Pi

E match
  case pi => s"strange math? pi = $pi"
 // case _ => "Ok"

// Listing 13.7 · A pattern match with a constructor pattern.
def deepMatch(expr: Expr): String =
  expr match
    case BinOp("+", e, Num(0)) => "a deep match"
    case _  => ""

deepMatch(zeroExpr)
deepMatch(BinOp("+", varExpr, zeroExpr))

// Sequence patterns

// Listing 13.8 · A sequence pattern with a fixed length.
def startsWithZero1(xs: List[Int]): String =
  xs match
    case List(0, _, _) => "found it"
    case _  => ""

startsWithZero1(List(0, 1, 2))
startsWithZero1(List(2, 3, 4))

// Listing 13.9 · A sequence pattern with an arbitrary length.
def startsWithZero2(xs: List[Int]): String =
  xs match
    case List(0, _*) => "found it"
    case _  => ""

startsWithZero2(List(0))
startsWithZero2(List(0, 1, 2))
startsWithZero2(List(2, 3, 4))
startsWithZero2(List(1))

// Listing 13.10 · A pattern match with a tuple pattern.
def tupleDemo(obj: Any): String =
  obj match
    case (a, b, c) => s"matched $a$b$c"
    case _  => ""

tupleDemo(("a ", 3, "-tuple"))

// Listing 13.11 · A pattern match with typed patterns
def generalSize(x: Any): Int =
  x match
    case s: String   => s.length
    case m: Map[_,_] => m.size
    case _   => -1

generalSize("abc")
generalSize(Map( 1 -> 'a', 2 -> 'b'))
generalSize(math.Pi)

def isInstance(expr: Any): Int =
  if (expr.isInstanceOf[String]) {
    val s = expr.asInstanceOf[String]
    s.length
  } else 0

"isInstance(\"foo\") [" + isInstance("foo") + "]"

def isIntIntMap(x: Any): Boolean =
  x match
    case m: Map[Int, Int] => true
    case _  => false

isIntIntMap(Map(1 -> 1))
isIntIntMap(Map("abc" -> "abc"))

// Arrays are checked at runtime
def isStringArray(x: Any): String =
  x match
    case a: Array[String] => "yes"
    case _  => "no"

isStringArray(Array("abc"))
isStringArray(Array(1, 2, 3))

// Variable binding

def matchUnOp(expr: Expr) =
  expr match
    case UnOp("abs", e @ UnOp("abs", _)) => e
    case _  =>

// 13.3 Pattern guards

def simplifyAdd(e: Expr): Expr =
  e match
    case BinOp("+", x, y) if x == y =>
      BinOp("*", x, Num(2))
    case _  => e

simplifyAdd(BinOp("+", Num(4), Num(4)))

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

