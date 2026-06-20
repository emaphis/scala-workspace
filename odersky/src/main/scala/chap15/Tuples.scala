// Chapter 15
// Working with Other Collections

// 15.5 Tuples

package chap15

object Tuples {
  def longestWord(words: Array[String]): (String, Int) =
    var word = words(0)
    var idx = 0
    for i <- 1 until words.length do {
      if words(i).length > word.length then
        word = words(i)
        idx = i
    }
    (word, idx)


  def main(args: Array[String]): Unit = {
    val longest = longestWord("The quick brown fox".split(" "))
    println(longest)
  }
}
