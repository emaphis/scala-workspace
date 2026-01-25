# Notes of Week 1

## 1.2 Elements of programming

### Programming languages provide

* primateve expresions
* ways to combine experssions
* ways to abstract expression

Read-Eval-Pring Loop - REPL

> scala

### Lecture 1.3 Evaluation Strategies and Termination

A non-primative expression is avaluated as follows

1 Take leftmost operator
2 Evaluate is operands (left before right)
3 Apply the operator to the operands

A name is evaluated by replacing it with the right hand of its definition

The evaluation process stops once it results in a value

A value is a number (for now)

Later on we ill consider other kinds of values

### Example

```Scala
def pi = 3.14159

def radius = 10

(2 * pi) * radius
(2 * 3.14159) * radius
6.28318 * radius
6.28318 * 10

// val res3: Double = 62.8318
```

### Function definition

```Scala
scala> def square(x: Double) = x * x
def square(x: Double): Double

scala> square(2)
val res5: Double = 4.0

scala> square(5 + 4)
val res6: Double = 81.0

scala> square(square(4))
val res7: Double = 256.0
```

### Evaluation of Function Applications

Application of parameterized functions are evaluated in a simular way as operators

1 Evaluate all function arguments form left to right.
2 Replace the function application by the functions right-hand side,
    and at the same time:
3 Replace the formal parameters of the function by the actual arguments.

### Example

```Scala
def sumOfSquares(x: Int, y: Int) = square(x) + square(y)

sumOfSquares(3, 2+2)
sumOfSquares(3, 4)
square(3) + square(4)
3 * 3 + square(4)
9 + square(4)
9 + 4 * 4
9 + 5
25

//val res8: Double = 25.0
```

### The substitution model

This scheme of expression evaluation is called the substitution model

And expresion is evaluated to a value

It can be applied to all expressions, as long as they have no side  effects.

The substitution model is formalized as the lambda calculus

### Termination

Does every expression reduce to a value (in a finite number of steps)?

No:

```Scala
def loop: int = loop

loop
```

### Changing the evaluation strategy

The interpreter feduces function arguements to values before rewitting the function application.

One coud aternatively apply the function to unreduced arguements

Forinstance:

```Scala
sumOfSquares(3, 2+2)
square(3) + square(2+2)
3 * 3 + square(2+2)
9 + square(2+2)
9 + (2+2) * (2+2)
9 + 4 * (2+2)
9 + 4 * 4
9 + 16
24
```

### Call-by-name and call-by value

* Both strategies reduce to the same value
* Both reduce expresions of pure functions
* Both terminate

Call-by-value has the advantage that function aguments are avaluated once

Call-by-name has the advantage that a funcion argument is not evaluated if the corresponding parameter is unused in the evaluation of the function body. (Lazy)

## Lecture 1.4 Conditionals and Value definitions

### Conditional Expressions

it-then-else - Like java but forms an expression and not a statement.

```Scala
def abs(x: Int) = if x >= 0 then x else -x

// x >= 0 is a predicate, of type Boolean
```

### Boolean Expresions

```Scala
true false      // Constants
!b              // Negation
b && b          // Conjucntion
b || b          // Disjunction
```

Rewrite rules for booleans

Reduction rules for Booleans

```Scala
!true       --> false
!false      --> true
true && e   --> e
false && e  --> false
true || e   --> true
false || e  --> e
```

&& and || are lazy, they only evaluate their second arguemtns if necessary.

### Value Definitions

Function paramaters can be passed by value or passed by nmame

Same applies with value defininitions

The `def` for is "by-name", its right hand side ti evaluated on each use.

The `val` form is "by-value":

```Scala
val x = 2
val y = square(x)
```

The right hand side is evaluated at the point of definition.

`y` refers to 4 and not square(2)

### Value Definitions and Termination

`val` and `def` become apparent when the right hand does not terminate.

```scala
def loop: Boolean = loop

// A definition

def x = loop

// is Ok, but s definition

val x = loop

// will lead to an infited loop
```

### Exercise

Write functions and and or such that for all arguments express x and y:

 and(x, y)   ==   x && y
 or(x, y)    == x || y

(do not use || and && in your implementation)

What are good operand to test that the equalitis hold?

```Scala
def and(x: Boolean, y: Boolean): Boolean = if x then y else false
def or (x: Boolean, y: Boolean): Boolean = if x then true else y
```

## Lecture 1.5 - Example: square roots with Newton's method

### Task

Define `sqrt` using Newtons method:

```Scala
/** Calculates the square root of the parameter */
def sqrt(x: Double): Double = ...
```

### Method to compute sqrt(x)

* Start with an intitial estimate y (let's pick y = 1)
* Repeatedly imporove the estimate by taking the means of y and x/y

### Example sqrt(2)

* Estimation    Quotient            Mean
* 1             2 / 1 = 2           1.5
* 1.5           2 / 1.5 = 1.333     1.4167
* 1.4167        2 / 1.4167 = 1.4118 1.4142

### Implementation of sqrt in Scala, Take 1

Define a function which computes on iteration step

```Scala
def sqrtIter(guess: Double, x: Double): Double =
   if isGoodEnough(guess, x) then guess
   else sqrtIter(improve(guess, x), x)
```

Note that `sqrIter` is recursive, its right-hand side calls itself.

Recursive functions need an explicit return type in Scala

For non-recursive functions, the return type is optional

```Scala
def improve(guess: Double, x: Double): Double =
  (guess + x / guess) / 2.0

def isGoodEnough(guess: Double, x: Double): Boolean =
  abs(guess * guess - x) < 0.001

def sqrt(x: Double) = sqrtIter(1.0, x)
```

## Lecture 1.6 - Blocks and Lexical Scope

### Nested functions

Good functional style to split a tast into many small functons

But names of functions like sqrtIter, improve and isGoodEnough mattere only for the implementation of sqrt, not its usage

We don't need to access these functions in other code.

We can achieve this by creatinga sqrt block and putting the auxcilliary inside the block.

### The sqrt function, Take 2

```Scala
def sqrt(x: Double) = 
    def sqrtIter(guess: Double, x: Double): Double =
        if isGoodEnough(guess, x) then guess
        else sqrtIter(improve(guess, x), x)

    def improve(guess: Double, x: Double): Double =
        (guess + x / guess) / 2.0

    def isGoodEnough(guess: Double, x: Double): Boolean =
        abs(guess * guess - x) < 0.001

    sqrtIter(1.0, x)
```

### Blocks in Scala

A block is delimitated by braces { ... }

```Scala
    { val x = f(3)
      x * x
    }
```

It contains a sequence of definitions or expressions

The last element of a block is an expression that defines its value

The return expression can be proceded by auxiliary definitions

Blocks themselves are expressions, a block may appear everywhere an expression can

In Scala 3, braces are optional, blocks are also indicated by indentation

### Blocks and Visibility

The definitions inside a block are only visible from within the block

The defininitions inside a block shadow definitions of the same names outside a block

### Exercise

What is the value of the following code segment

```Scala
    val x = 0
    def f(y: Int) = y + 1
    val y =
        val x = f(3)
        x * x
    val result = y + x

    // 16 + 0
    // result = 16
```

### Lexical Scoping

Definitions of outer blocks are visible inside a block unless they are shadowed

So we can simplify sqrt by eliminating redundant occurances of the x parameter, which means everywhere the same thing:

### The sqrt Function, Take 3

```Scala

def sqrt(x: Double): Double =
    def sqrtIter(guess: Double): Double =
        if isGoodEnough(guess) then guess
        else sqrtIter(improve(guess))

    def improve(guess: Double): Double =
        (guess + x / guess) / 2.0

    def isGoodEnough(guess: Double): Boolean =
        abs(guess * guess - x) < 0.001

    sqrtIter(1.0)
```

### Semicolons

If there are more than one statement on a line, they must be separated by semicolons:

```Scala
    val y = x + 1; y * y
```

## Summary

* Arithmetic and boolean expressions
* Conditional expressions if-then-else
* Functions with recursion
* Nesting and lexical scope

The difference between call-by-name and call-by=value evaluation strategies

Reasoning about programm execution: reduce expressions using the substitution model.

That model will be an important tool in the comming sessions

## Lecture 1.7 - Tail recursion

### Review: Evaluating a Function Application

One simple rule: One evaluates a function application f(e1, ..., en)

* by evaluating the expression e1, ..., e2n resulting in the values v1, ... vn then
* by replacing the application with the body of the f, in which
* the actual parameters v1, ..., vn replace the fromal parameters of f

### Application Rewriting Rule

This can be formalized as a `rewriting of the program itself`.

```Scala
    def f(x1, ..., xn) = B; ... f(v1, ..., vn)
-->
    def f(x1, ..., xn) = B; ... [v1/x1, ..., vn/xn]B
```

Here, [v1/x1, ..., vn/xn]B means

The expression B in which all occurences of x1 have been replaced by v1

[v1/x1, ..., vn/xn] is called `subsitution`

### Rewriting example

Consider `gcd`, the function that computes the greatest common divisor of two numbers

Here's an implementation of `gcd` using Euclid's algorithm

```Scala
    def gcd(a: Int, b: Int): Int =
        if b == 0 then a else gcd(b, a % b)
```

### Rewriting Example

gcd(14, 21) is evaluated as follows

```Scala
gcd(14, 21)
-> if 21 == 0 then 14 else gcd(21, 14 $% 21)
-> if false then 14 else gcd(21, 14 % 21)
-> gcd(21, 14 % 21)
-> gcd(21, 14)
-> if 14 == 0 then 21 else  gcd(14, 21 % 14)
-> gcd(14, 7)
-> gcd(7, 0)
-> y
```

### Another rewrting example

```Scala
    def factorial(n: Int): Int =
       if n == 0 then 1 else n * factorial(n - 1)
```

### factorial(4)

``` Scala
factorial(4)
-> if 4 == 0 then 1 else 4 * factorial(4 - 1)
-> 4 * factorial(3)
-> 4 * (3 * factorial(2))
-> 4 * (3 * (2 *  factorial(1)))
-> 4 * (3 * (2 * (1 * factorial(0))))
-> 4 * (3 * (2 * (1 * 1)))
-> 4 * (3 * (2 * 1))
-> 4 * (3 * 2)
-> 4 * 6
-> 24
```

### Tail Recursion

Implementation Consideration

If a function alls itself as its last action, the functions stack frame can be reused. This is calle tail recursion

=> Tail recursive functions are iterative process

In general, it the last action of a function consists of calling a function (which may be the same), one stack frame would be sufficient for both functions

### Tail Recursion in Scala

Only directly recursive call to the current function are optimized.

One can require a function is tail-recursive by using `@tailrec` annotation

```Scala
import scala.annotation.tailrec

@tailrec
def gce(a: Int, b: Int): Int = ...
```

If the annotation is used on a function that is not tail-recursive an errer will result.

### Exercise - a tail-recursive version of factorial

```Scala
import scala.annotation.tailrec

def factorial(n: Int): Int =

    @tailrec 
    def loop(n: Int, acc: Int): Int =
        if n == 0 then acc 
        else loop(n - 1, n * acc)

    loop(n, 1)
```
