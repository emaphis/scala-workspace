// Chapter 14
// Working with Lists

// 14.10 Understanding Scala’s type inference algorithm

package chap14

// Listing 14.2 · A merge sort function for Lists.
object TypeInference {

  def msort[T](less: (T, T) => Boolean)
              (xs: List[T]): List[T] =

    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if less(x, y) then x :: merge(xs1, ys)
          else y :: merge(xs, ys1)

    val n = xs.length / 2
    if n == 0 then xs
    else
      val (ys, zs) = xs.splitAt(n)
      merge(msort(less)(ys), msort(less)(zs))


  def main(args: Array[String]): Unit = {
    val abcde = List('a', 'b', 'c', 'd', 'e')

    val lst1 =
      msort((x: Char, y: Char) => x > y)(abcde)
    println(lst1)

    val lst2 =
      abcde.sortWith(_ > _)
    println(lst2)

    val lst3 =
      msort[Char](_ > _)(abcde)   // pass an explicit type
    println(lst3)
  }

}
