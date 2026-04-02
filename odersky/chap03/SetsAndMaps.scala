// Step 10. Use sets and maps

import scala.collection.mutable
import scala.collection.immutable.HashSet

object SetsAndMaps {
  def main(args: Array[String]): Unit = {
    println("Sets and Maps")

    // Listing 3.5 · Creating, initializing, and using an immutable set.
    var jetSet = Set("Boeing", "Airbus")
    jetSet += "Lear"
    val query = jetSet.contains("Cessna")  // false
    println("jetSet [" + jetSet + "] contains Cessna = " + query)

    // Listing 3.6 · Creating, initializing, and using a mutable set.
    val movieSet = mutable.Set("Spotlight", "Moonlight")
    movieSet += "Parasite"
    println("movieSet [" + movieSet + "]")

    val hashSet = HashSet("Tomatoes", "Chilies")
    val ingredients = hashSet + "Coriander"
    println("ingredients [" + ingredients + "]")

    // Listing 3.7 · Creating, initializing, and using a mutable map.
    val treasureMap = mutable.Map.empty[Int, String]
    treasureMap += (1 -> "Go to island.")
    treasureMap += (2 -> "Find big X on ground.")
    treasureMap += (3 -> "Dig.")
    val step2 = treasureMap(2)
    println("step 2 " + step2)

    // Listing 3.8 · Creating, initializing, and using an immutable map.
    val romanNumeral = Map(
      1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
    )
    val four = romanNumeral(4)
    println("four  = " + four)
  }
}
