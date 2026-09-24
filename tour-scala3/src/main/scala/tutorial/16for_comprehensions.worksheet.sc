// For Comprehensions

case class User(name: String, age: Int)

val userBase = List(
  User("Travis", 28),
  User("Kelly", 33),
  User("Jennifer", 44),
  User("Dennis", 23))

val twentySomethings =
  for user <- userBase if user.age >= 20 && user.age < 30
  yield user.name

twentySomethings.foreach(println)


def foo(n: Int, v: Int) =
  for i <- 0 until n
      j <- 0 until n if i + j == v
   yield (i, j)

foo(10, 10).foreach {
  (i, j) => println(s"($i, $j) ")
}

// You can omit yield in a comprehension. In that case, comprehension will return Unit.

def foo1(n: Int, v: Int): Unit =
  for i <- 0 until n
      j <- 0 until n if i + j == v
  do println(s"$i, $j)")

foo1(10, 10)
