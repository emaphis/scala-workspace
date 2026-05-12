// Chapter 14
// Working with Lists

// Example: Merge sort

package chap14

// Listing 14.2 · A merge sort function for Lists.
object MergeSort {

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
    val mixedInts = List(4, 1, 9, 0, 5, 8, 3, 6, 2, 7)

    val srt1 = msort((x: Int, y: Int) => x < y)(mixedInts)

    val intSort = msort((x: Int, y: Int) => x < y)
    val srt2 = intSort(mixedInts)

    val reverseIntSort = msort((x: Int, y: Int) => x > y)
    val srt3 = reverseIntSort(mixedInts)

    println(mixedInts)
    println(srt1)
    println(srt2)
    println(srt3)
  }

}
