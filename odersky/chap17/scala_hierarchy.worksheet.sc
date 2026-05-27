// Chapter 17
// Scala’s Hierarchy

// 17.1 Scala’s class hierarchy

//new Int
//Int is abstract; it cannot be instantiated

//val i: Int = null
// Required: Int

//  Any has two subclasses: AnyVal and AnyRef


//class Dollars(val amount: Int) extends AnyVal:
//  override def toString: String = "$" + amount

//class SwissFranks(val amount: Int) extends AnyVal:
//  override def toString: String = s"$amount CHF"

//val dollars = Dollars(1000)
//val franks = SwissFranks(1000)

// Value classes also inherit all methods from classAny

42.toString   // "42"
42.hashCode   // 42
42.equals(42) // true

42.max(43)    // 43
42.min(43)    // 42
1 until 5     // Range 1until 5
1 to 5        // Range 1 to 5
3.abs         // 3
-3.abs        // 3


// 17.3 Bottom types

sys.error("I am in error")
// ava.lang.RuntimeException: I am in error


def divide(x: Int, y: Int): Int =
  if y != 0 then x / y
  else sys.error("cant divide by zero")

divide(20, 5)

try {
  divide(5, 0)
} catch {
  case ex: Exception => println("ex: [" + ex + "]")
}



// 17.5 Intersection types
object IntersectionTypes:
  import chap11.IntQueue
  import chap11.Ex02.{BasicIntQueue, Incrementing, Filtering}
  
  val q = new BasicIntQueue with Incrementing with Filtering
  //val q: BasicIntQueue & Incrementing & Filtering = anon$1@49f56fbe
  
  // Compiles because B & I & F <: I & F
  //val q2: Incrementing & Filtering = q
  val q2: Incrementing & Filtering = q
  
  // Compiles because I & F is equivalent to F & I
  val q3: Filtering & Incrementing = q2


// 17.6 Union types
object UnionTypes:

  trait Fruit
  trait Plum extends Fruit
  trait Apricot extends Fruit
  trait Pluot extends Plum, Apricot

  val plumOrApricot: Plum | Apricot = new Plum { }

  // This compiles fine,becausePlum|Apricot<:Fruit
  val fruit : Fruit = plumOrApricot

  // But you cannot use a Fruit where Plum | Apricot is needed
  //val doesNotCompile: Plum | Apricot = fruit

  def errorMessage(msg: Int | String): String =
    msg match
      case n: Int => s"Error number: ${n.abs}"
      case s: String => s + "!"

  errorMessage("Oops")
  errorMessage(-42)


// 17.7 Transparent traits
object TransparentTraits:
  import chap11.IntQueue
  import chap11.Ex02.BasicIntQueue

  val qz = new BasicIntQueue
    with Incrementing  with Filtering

  transparent trait Incrementing extends IntQueue:
    abstract override def put(x: Int): Unit = super.put(x + 1)

  transparent trait Filtering extends IntQueue:
    abstract override def put(x: Int): Unit =
      if x >= 0 then super.put(x)
