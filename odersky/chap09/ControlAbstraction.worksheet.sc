// Chapter 9
// Control Abstraction

// 9.2 Simplifying client code

def containsNeg(nums: List[Int]): Boolean =
  var exists = false
  for num <- nums do
    if num < 0 then
      exists = true
  exists

containsNeg(List(1, 2, 3, 4))
containsNeg(List(1, 2,-3, 4))

def containsNeg2(nums: List[Int]) = nums.exists(_ < 0)

containsNeg2(Nil)
containsNeg2(List(0, -1, -2))

def containsOdd(nums: List[Int]): Boolean =
  var exists = false
  for num <- nums do
    if num % 2 == 1 then
      exists = true
  exists

def containsOdd2(nums: List[Int]) = nums.exists(_ % 2 == 1)


// 9.3 Currying

def plainOldSum(x: Int, y: Int) = x + y
plainOldSum(1, 2)

// Listing 9.3 · Defining and invoking a curried function.
def curriedSum(x: Int)(y: Int) = x + y
curriedSum(1)(2)  // two function invocations

def first(x: Int) = (y: Int) => x + y

val second = first(1)

val onePlus = curriedSum(1)
onePlus(2)

val twoPlus = curriedSum(2)
twoPlus(2)


// 9.4 Writing new control structures
// create methods that take functions as arguments.

def twice(op: Double => Double, x: Double) = op(op(x))
twice(_ + 1, 5)


// 9.5 By-name parameters

var assertionsEnabled = true

def myAssert(predicate: () => Boolean): Unit =
  if assertionsEnabled && !predicate() then
    throw new AssertionError

myAssert(() => 5 > 3)
