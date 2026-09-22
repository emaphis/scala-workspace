// Multiple Parameter Lists

//trait Iterable[A]:
//  ...
//  def foldLeft[B](z: B)(op: (B, A) => B): B
//  ...

val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

val res1 = numbers.foldLeft(0)((m, n) => m + n)
println(res1)


//* Use cases *

// Drive type inference

def foldLeft1[A, B](as: List[A], b0: B, op: (B, A) => B) =
  @annotation.tailrec
  def loop(remaining: List[A], acc: B): B = remaining match
    case Nil          => acc // Base case: no more elements
    case head :: tail => loop(tail, op(acc, head)) // Apply op and recurse
  loop(as, b0)

// Can't be called this way.
def notPossible =  foldLeft1(numbers, 0, _ + _)
println(notPossible)

// But can be called like
def firstWay = foldLeft1[Int, Int](numbers, 0, _ + _)
println(firstWay)
def secondWay = foldLeft1(numbers, 0, (a: Int, b: Int) => a + b)
println(secondWay)

def foldLeft2[A, B](as: List[A], b0: B)(op: (B, A) => B) =
  @annotation.tailrec
  def loop(remaining: List[A], acc: B): B = remaining match
    case Nil          => acc // Base case: no more elements
    case head :: tail => loop(tail, op(acc, head)) // Apply op and recurse
  loop(as, b0)

def possible = foldLeft2(numbers, 0)(_ + _)
println(possible)


// Implicit parameters

// Partial application

val numbers2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

val numberFunc = numbers2.foldLeft(List[Int]())
// val numberFunc: ((List[Int], Int) => List[Int]) => List[Int] = ???

val squares = numberFunc((xs, x) => xs :+ x*x)

val cubes = numberFunc((xs, x) => xs :+ x*x*x)


// Comparison with “currying”

// version with multiple parameter lists
def addMultiple(n1: Int)(n2: Int) = n1 + n2
// two different ways of arriving at a curried version instead
def add(n1: Int, n2: Int) = n1 + n2
val addCurried1 = (add _).curried
val addCurried2 = (n1: Int) => (n2: Int) => n1 + n2
// regardless, all three call sites are identical
addMultiple(3)(4)
addCurried1(3)(4)
addCurried2(3)(4)


