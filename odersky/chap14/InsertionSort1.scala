// Chapter 14
// Working with Lists

// 14.4 Basic operations on lists

// Listing 14.1 · Sorting a List[Int] via the insertion sort algorithm.

package chap14

object InsertionSort1 {

  def isort(xs: List[Int]): List[Int] =
    if xs.isEmpty then Nil
    else insert(xs.head, isort(xs.tail))

  def insert(x: Int, xs: List[Int]): List[Int] =
    if xs.isEmpty || x <= xs.head then x :: xs
    else xs.head :: insert(x, xs.tail)


  def main(args: Array[String]): Unit = {
    println("Insertion sort 1")
    println("isort(List(5, 3, 12)) [" + isort(List(5, 3, 12)) + "]")
  }
}
