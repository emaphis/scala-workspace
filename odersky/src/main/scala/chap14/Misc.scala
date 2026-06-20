// Chapter 14
// Working with Lists

package chap14

object Misc {

  // 14.6 First-order methods on class List
  // The Divide and Conquer principle

  def append[T](xs: List[T], ys: List[T]): List[T] =
    xs match
      case List() => ys
      case x :: xs1 => x :: append(xs1, ys)

  // Reversing lists: reverse
  def rev[T](xs: List[T]): List[T] =
    xs match
      case List() => xs
      case x :: xs1 => rev(xs1) ::: List(x)

  // Predicates over lists: forall and exists
  def hasZeroRow(m: List[List[Int]]): Boolean =
    m.exists(row => row.forall(_ == 0))

  // Folding lists: foldLeft and foldRight
  def sumL(xs: List[Int]): Int = xs.foldLeft(0)(_ + _)
  def produceL(xs: List[Int]): Int = xs.foldLeft(1)(_ * _)




  def main(args: Array[String]): Unit = {
    println("Working with Lists")

    val fruit = List("apple", "orange", "pears")
    val nums = List(1, 2, 3, 4)
    val diag3 =
      List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1)
      )
    val empty = List()

    val xs = 1 :: 2 :: 3 :: 4 :: Nil

    println("fruit = " + fruit)

    // Table 14.1 · Basic list operations
    println(empty.isEmpty)
    println(fruit.isEmpty)
    println(fruit.head)
    println(fruit.tail)
    println(fruit.tail.head)
    println(diag3.head)

    // 14.5 List patterns
    val List(a, b, c) = fruit
    println("fruit [a, b, c] = [" + a + ", " + b + ", " + c + "]")

    // 14.6 First-order methods on class List

    // Concatenating two lists
    println(List(1, 2) ::: List(3, 4, 5))
    println(List() ::: List(1, 2, 3))
    println(List(1, 2, 3) ::: List(4))

    println(append(List(1, 2), List(3, 4, 5)))

    // Taking the length of a list: length
    println(List(1, 2, 3).length)

    // Accessing the end of a list: init and last
    val abcde = List('a', 'b', 'c', 'd', 'e')
    println(abcde.last)
    println(abcde.init)

    // Reversing lists: reverse
    println(abcde.reverse)
    println(abcde.reverse.reverse)
    println(rev(abcde))


    // Prefixes and suffixes: drop, take, and splitAt
    // The drop and take operations generalize tail and init
    // xs.splitAt(n) equals (xs.take(n), xs.drop(n))
    println(abcde.take(2))
    println(abcde.drop(2))
    println(abcde.splitAt(2))

    // Element selection: apply and indices
    // xs.apply(n) equals (xs.drop(n)).head
    println(abcde.apply(2)) // expensive for lists
    println(abcde(2))
    println(abcde.indices)


    // Flattening a list of lists: flatten
    println(List(List(1, 2), List(3), List(), List(4, 5)).flatten)

    println(fruit.map(_.toList).flatten)
    println(fruit.flatMap(_.toList))

    // Zipping lists: zip and unzip
    println(abcde.indices.zip(abcde))
    val zipped = abcde.zip(List(1, 2, 3))
    println(zipped)
    println(abcde.zipWithIndex)
    println(zipped.unzip)

    // Displaying lists: toString and mkString
    println(abcde.toString)

    println(abcde.mkString("[", ",", "]"))
    println(abcde.mkString(""))
    println(abcde.mkString)
    println(abcde.mkString("List(", ", ", ")"))

    // Converting lists: iterator, toArray, copyToArray
    val arr = abcde.toArray
    println(arr.toList)

    val arr2 = new Array[Int](10)
    println(List(1, 2, 3).copyToArray(arr2, 3))
    println(arr2.mkString("Array(", ", ", ")"))

    val it = abcde.iterator
    println(it.next())
    println(it.next())

    // 14.7 Higher-order methods on class List

    // Mapping over lists: map, flatMap and foreach

    println(List(1, 2, 3).map(_ + 1))
    val words = List("the", "quick", "brown", "fox")
    println(words.map(_.length))
    println(words.map(_.toList.reverse.mkString))

    println(words.map(_.toList))
    println(words.flatMap(_.toList))

    val lst1 =
      List.range(1, 5).flatMap(
        i => List.range(1, i).map(j => (i, j))
      )

    val lst2 =
      for i <- List.range(1, 5);
          j <- List.range(1, i)
      yield (i, j)

    println(lst1)
    println(lst2)

    var sum = 0
    List(1, 2, 3, 4, 5).foreach(sum += _)
    println(sum)

    println(hasZeroRow(diag3))

    println("sum of xs = " + sumL(xs))
    println("product of xs = " + produceL(xs))

  }

}
