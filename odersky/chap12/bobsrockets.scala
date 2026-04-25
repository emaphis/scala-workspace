

// Listing 12.6 · Accessing hidden package names

package chap12.bobsrockets:

  //mport chap12.bobsrockets.launch.Booster1

  package launch:
    class Booster2

  package navigation
    package launch:
      class Booster1

    class MissionControl:
      val booster1 = new chap12.bobsrockets.launch.Booster1

