// Chapter 12
// Packages, Imports, and Exports

// 12.1 Putting code in packages

// Listing 12.1 · Placing the contents of an entire file into a package.
//package chap12.bobsrockets.navagation

//class Navigator


// Listing 12.2 · Long form of a simple package declaration.

//package chap12.bobsrockets.navigation:

  //class Navigator


// Listing 12.3 · Multiple packages in the same file.
/*
package chap12.bobsrockets:
  package navigation:

    // In package bobsrockets.navigation
    class Navigator

    package launch:

      // In package bobsrockets.navigation.launch
      class Booster
*/

// Listing 12.4 · Concise access to classes and packages.

package chap12.bobsrockets:
  package navigation:

    // In package bobsrockets.navigation
    class Navigator:
      //  No need to say bobsrockets.navigation.StarMap
      val map = new StarMap

    class StarMap

    class Ship:
      // No need to say bobsrockets.navigation.Navigator
      val nav = new Navigator

    package fleets:
      class Fleet:
        //  No need to say bobsrockets.Ship
        def addShip(): Ship = new Ship


    package launch:

      // In package bobsrockets.navigation.launch
      class Booster
