//

object ForYield {
  def main(args: Array[String]): Unit = {
    val adjectives = List("One", "Two", "Red", "Blue")

    // transform with map
    val nouns1 = adjectives.map(adj => adj + " Fish")
    println("Nouns = " + nouns1)

    // transform with for-yield expression - transformed into a for expression
    val nouns2 =
      for adj <- adjectives yield
        adj + " Fish"

    println("Nouns = " + nouns2)

    // Results of map are always another list
    val lengths1 = nouns2.map(noun => noun.length)
    println("lengths = " + lengths1)

    val lengths2 =
      for noun <- nouns2 yield
        noun.length
    println("lengths = " + lengths2)

    // Maps over Vectors
    val ques = Vector("Who", "What", "When", "Where", "Why")
    val usingMap = ques.map(q => q.toLowerCase() + "?")

    println("Questions = " + usingMap)

    val usingForYield =
      for q <- ques yield
        q.toLowerCase() + "?"

    println("Questions = " + usingForYield)

    // Using the option type
    val startsW = ques.find(q => q.startsWith("W")) // Some(Who)
    val hasLen4 = ques.find(q => q.length == 4)     // Some(What)
    val hasLen5 = ques.find(q => q.length == 5)     // Some(Where)
    val startsH = ques.find(q => q.startsWith("H")) // None
  }
}
