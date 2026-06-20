// Chapter 14
// Working with Lists

// 14.1 List literals

val fruit = List("apple", "orange", "pears")
val nums = List(1, 2, 3, 4)
val diag3 =
  List(
    List(1, 0, 0),
    List(0, 1, 0),
    List(0, 0, 1)
  )
val empty = List()


// 14.2 The List type

val fruit1: List[String] = List("apple", "orange", "pears")
val nums1: List[Int] = List(1, 2, 3, 4)
val diag31: List[List[Int]] =
  List(
    List(1, 0, 0),
    List(0, 1, 0),
    List(0, 0, 1)
  )
val empty1: List[Nothing] = List()

// List[Nothing] is also of type List[String]!
val empty1a: List[String] = List()

// 14.3 Constructing lists

val fruit2 = "apples" :: ("oranges" :: ("pears" :: Nil))
val nums2 = 1 :: (2 :: (3 :: (4 :: Nil)))
val diag32 = (1 :: (0 :: (0 :: Nil))) ::
  (0 :: (1 :: (0 :: Nil))) ::
  (0 :: (0 :: (1 :: Nil))) :: Nil
val empty2 = Nil

// no parenthesis
val xs = 1 :: 2 :: 3 :: 4 :: Nil


// 14.4 Basic operations on lists

// Nil.head  // Exception

// Table 14.1 · Basic list operations
empty.isEmpty
fruit.isEmpty
fruit.head
fruit.tail
fruit.tail.head
diag3.head

// Listing 14.1 · Sorting a List[Int] via the insertion sort algorithm.


def insert(x: Int, xs: List[Int]): List[Int] =
  if xs.isEmpty || x <= xs.head then x :: xs
  else  xs.head :: insert(x, xs.tail)

def isort(xs: List[Int]): List[Int] =
  if xs.isEmpty then Nil
  else insert(xs.head, isort(xs.tail))

isort(List(5, 3, 12))


// 14.5 List patterns

val List(a, b, c) = fruit

//val a1 :: b2 :: rest2 = fruit

// Taking lists apart with patterns is an alternative to taking them apart with the
// basic methods head, tail

def insert2(x: Int, xs: List[Int]): List[Int] =
  xs match
    case List()  => List(x)
    case y :: ys => if x <= y then x :: xs
                    else y :: insert2(x, ys)

def isort2(xs: List[Int]): List[Int] =
  xs match
    case List()   => List()
    case x :: xs1 => insert2(x, isort2(xs1))

isort2(List(5, 3, 12))


// 14.6 First-order methods on class List

// Concatenating two lists

List(1, 2) ::: List(3, 4, 5)
List() ::: List(1, 2, 3)
List(1, 2, 3) ::: List(4)

// The Divide and Conquer principle

def append[T](xs: List[T], ys: List[T]): List[T] =
  xs match
    case List() => ys
    case x :: xs1 => x :: append(xs1, ys)

append(List(1, 2), List(3, 4, 5))

// Taking the length of a list: length
List(1, 2, 3).length

// Accessing the end of a list: init and last
val abcde = List('a', 'b', 'c', 'd', 'e')
abcde.last
abcde.init

// Reversing lists: reverse
abcde.reverse

abcde.reverse.reverse

def rev[T](xs: List[T]): List[T] =
  xs match
    case List() => xs
    case x :: xs1 => rev(xs1) ::: List(x)

rev(abcde)

// Prefixes and suffixes: drop, take, and splitAt
// The drop and take operations generalize tail and init
// xs.splitAt(n) equals (xs.take(n), xs.drop(n))

abcde.take(2)
abcde.drop(2)
abcde.splitAt(2)

// Element selection: apply and indices
// xs.apply(n) equals (xs.drop(n)).head

abcde.apply(2)  // expensive for lists
abcde(2)

abcde.indices

// Flattening a list of lists: flatten
List(List(1, 2), List(3), List(), List(4, 5)).flatten

fruit.map(_.toList).flatten
fruit.flatMap(_.toList)

// Zipping lists: zip and unzip
abcde.indices.zip(abcde)
val zipped = abcde.zip(List(1, 2, 3))
abcde.zipWithIndex
zipped.unzip

// Displaying lists: toString and mkString
abcde.toString

abcde.mkString("[", ",", "]")
abcde.mkString("")
abcde.mkString
abcde.mkString("List(", ", ", ")")

// Converting lists: iterator, toArray, copyToArray
val arr = abcde.toArray
arr.toList

val arr2 = new Array[Int](10)
List(1, 2, 3).copyToArray(arr2, 3)
arr2

val it = abcde.iterator
it.next()
it.next()

// 14.7 Higher-order methods on class List

// Mapping over lists: map, flatMap and foreach

List(1, 2, 3).map(_ + 1)
val words = List("the", "quick", "brown", "fox")
words.map(_.length)
words.map(_.toList.reverse.mkString)

words.map(_.toList)
words.flatMap(_.toList)

List.range(1, 5).flatMap(
  i => List.range(1, i).map(j => (i, j))
)

for i <- List.range(1, 5);
  j <- List.range(1, i)
  yield (i, j)

var sum = 0
List(1, 2, 3, 4, 5).foreach(sum += _)
sum

// Filtering lists: filter, partition, find, takeWhile, dropWhile, and
// span

List(1, 2, 3, 4, 5).filter(_ % 2 == 0)
words.filter(_.length == 3)

List(1, 2, 3, 4, 5).partition(_ % 2 == 0)

List(1, 2, 3, 4, 5).find(_ % 2 == 0)
List(1, 2, 3, 4, 5).find(_ <= 0)

List(1, 2, 3,-4, 5).takeWhile(_ > 0)
words.dropWhile(_.startsWith("t"))

List(1, 2, 3,-4, 5).span(_ > 0)

// Predicates over lists: forall and exists

def hasZeroRow(m: List[List[Int]]): Boolean =
  m.exists(row => row.forall(_ == 0))

hasZeroRow(diag3)

// Folding lists: foldLeft and foldRight

def sumL(xs: List[Int]): Int = xs.foldLeft(0)(_ + _)
sumL(xs)

def produceL(xs: List[Int]): Int = xs.foldLeft(1)(_ * _)
produceL(xs)

words.foldLeft("")(_ + " " + _)
words.tail.foldLeft(words.head)(_ + " " + _)

// Sorting lists: sortWith

List(1, -3, 4, 2, 6).sortWith(_ < _)
words.sortWith(_.length > _.length)

// 14.8 Methods of the List object

// Creating lists from their elements: List.apply
List.apply(1, 2, 3)

// Creating a range of numbers: List.range
List.range(1, 5)
List.range(1, 9, 2)
List.range(9, 1 -1)

// Creating uniform lists: List.fill
List.fill(5)('a')
List.fill(3)("hello")

List.fill(2, 3)('b')

