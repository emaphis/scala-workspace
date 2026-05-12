// Chapter 14
// Working with Lists

// Example: List reversal using fold

package chap14


object ReverseList:

  def reverseLeft[T](xs: List[T]): List[T] =
    xs.foldLeft(List[T]()) { (ys, y) => y :: ys}

  def main(args: Array[String]): Unit = {
    val lst = List(5, 7, 1, 3)
    println("list = " + lst)
    println("rev list = " + reverseLeft(lst))
  }
