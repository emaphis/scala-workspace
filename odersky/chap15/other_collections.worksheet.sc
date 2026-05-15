// Chapter 15
// Working with Other Collections

// 15.1 Sequences

// Lists
val colors = List("red", "blue", "green")
colors.head
colors.tail

// Arrays
val fiveInts = Array[Int](5)
val fiveToOne = Array(5, 4, 3, 2, 1)

fiveInts(0)

// List buffers
import scala.collection.mutable.ListBuffer
val LBuf = new ListBuffer[Int]
LBuf += 1
LBuf += 2
3 +=: LBuf  // add to front
LBuf.toList

// Array buffers
import scala.collection.mutable.ArrayBuffer
val aBuf = new ArrayBuffer[Int]()
aBuf += 12
aBuf += 13
aBuf.length
aBuf(0)
aBuf(1)

// Strings (via StringOps)
def hasUpperCase(s: String): Boolean =
  s.exists(_.isUpper)
hasUpperCase("Robert Frost")
hasUpperCase("e e cummings")


// 15.2 Sets and maps

import scala.collection.mutable
val mutaSet = mutable.Set(1, 2, 3)

// Using sets

// split
val text = "See Spot run. Run, Spot. Run!"
val wordsArray = text.split("[,.]+")

val words = mutable.Set.empty[String]

for word <- wordsArray do
  words += word.toLowerCase

words

// Using maps

val map = mutable.Map.empty[String, Int]
map("hello") = 1
map("there") = 2
map

map("hello")

// Putting it all together

def countWords(text: String) =
  val counts = mutable.Map.empty[String, Int]
  for rawWord <- text.split("[ ,!.]+") do
    val word = rawWord.toLowerCase
    val oldCount =
      if counts.contains(word) then counts(word)
      else 0
    counts += (word -> (oldCount + 1))
  counts

countWords("See Spot run! Run, Spot. Run!")

// Sorted sets and maps
import scala.collection.immutable.TreeSet
val ts = TreeSet(9, 3, 8, 0, 2, 7, 4, 6, 5)
val cs = TreeSet('f', 'u', 'n')

import scala.collection.immutable.TreeMap
var tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x')
tm += (2 -> 'x')
tm

// 15.3 Selecting mutable versus immutable collections
// See: Capitals.scala

// 15.5 Tuples
// see Tuples.scala
