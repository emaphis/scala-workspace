package example

object Lists:

  /**
   * This method computes the sum of all elements in the list xs. There are
   * multiple techniques that can be used for implementing this method, and
   * you will learn during the class.
   *
   * For this example assignment you can use the following methods in class
   * `List`:
   *
   *  - `xs.isEmpty: Boolean` returns `true` if the list `xs` is empty
   *  - `xs.head: Int` returns the head element of the list `xs`. If the list
   *    is empty an exception is thrown
   *  - `xs.tail: List[Int]` returns the tail of the list `xs`, i.e. the the
   *    list `xs` without its `head` element
   *
   *  ''Hint:'' instead of writing a `for` or `while` loop, think of a recursive
   *  solution.
   *
   * @param xs A list of natural numbers
   * @return The sum of all elements in `xs`
   */
  def sum(xs: List[Int]): Int =
    if xs.isEmpty then 0
    else xs.head + sum(xs.tail)
  

  /**
   * This method returns the largest element in a list of integers. If the
   * list `xs` is empty it throws a `java.util.NoSuchElementException`.
   *
   * You can use the same methods of the class `List` as mentioned above.
   *
   * ''Hint:'' Again, think of a recursive solution instead of using looping
   * constructs. You might need to define an auxiliary method.
   *
   * @param xs A list of natural numbers
   * @return The largest element in `xs`
   * @throws java.util.NoSuchElementException if `xs` is an empty list
   */
  def max(xs: List[Int]): Int =
    
    def loop(xs: List[Int], currentMax: Int): Int =
      if xs.isEmpty then currentMax
      else
        val newMax = if xs.head > currentMax then xs.head else currentMax
        loop(xs.tail, newMax)
    
    if xs.isEmpty then throw java.util.NoSuchElementException("empty list")
    else
      val currentMax = xs.head
      loop(xs.tail, currentMax)
    

@main def run(): Unit =
  println(Lists.sum(List()) == 0)
  println(Lists.sum(List(42)) == 42)
  println(Lists.sum(List(1, 2, 3)) == 6)
  println(Lists.sum(List(-1, -2, -3)) == -6)
  println(Lists.max(List(42)) == 42)
  println(Lists.max(List(1, 3, 2)) == 3)
  println(Lists.max(List(3, 7, 4)) == 7)
  println(Lists.max(List(3, 3, 3)) == 3)
