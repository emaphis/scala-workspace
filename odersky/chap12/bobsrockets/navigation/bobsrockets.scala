// Chapter 12
// Packages, Imports, and Exports

// 12.2 Concise access to related code

// Listing 12.6 · Accessing hidden package names

package chap12.bobsrockets:
  
  package launch:
    class Booster2

  package navigation:

    package launch:
      class Booster1

    class MissionControl:
      val booster1 = new launch.Booster1
      val booster2 = new chap12.bobsrockets.launch.Booster2
      val booster3 = new chap12.launch.Booster3
