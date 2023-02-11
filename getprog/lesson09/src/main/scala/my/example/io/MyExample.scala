// 9.2 Create a package

// Listing 9.3 Creating a package, my.example.io

//  File src/main/scala/my/example/io/MyExample.scala

package my.example.io

import scala.io.Source

class MyExample {
    def readFileIntoString(filename: String): String =
        Source.fromFile(filename).getLines().mkString("\n")
}
