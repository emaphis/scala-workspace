// Chapter 12
// Packages, Imports, and Exports

package chap12

import chap12.bobsrockets.navigation.launch._
import chap12.bobsrockets.navigation.fleets._

object Rocket {
  def main(args: Array[String]): Unit =
    val fleet = new Fleet
    val ship = fleet.addShip()

    println("Ship's navigator's star map [" + ship.nav.map + "]")
    val booster = Booster()
    println("Booster [" + booster + "]")
}

