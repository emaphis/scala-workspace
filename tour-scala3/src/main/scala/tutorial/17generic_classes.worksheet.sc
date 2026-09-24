// Generic Classes

// Generic classes are classes which take a type as a parameter.

//* Defining a generic class *

class Stack[A]:
  private var elements: List[A] = Nil
  def push(x: A): Unit =
    elements = x :: elements
  def peek: A = elements.head
  def pop(): A =
    val currentTop = peek
    elements = elements.tail
    currentTop


//* Usage *

val stack = Stack[Int]
stack.push(1)
stack.push(2)
println(stack.pop())
println(stack.pop())


// The instance stack can only take Ints. However, if the type argument had subtypes, those could be passed in

class Fruit
class Apple extends Fruit
class Banana extends  Fruit

val stackF = Stack[Fruit]
val apple = Apple()
val banana = Banana()

stackF.push(apple)
stackF.push(banana)


