// Lesson 9  -  Import and create packages

/// 9.1 Import an existing package

// Listing 9.1 Implementing readFileIntoString

import scala.io.Source  // Include Source from scala.io package

def readFileIntoString(filename: String) =
    Source.fromFile(filename)
          .getLines()
          .mkString("\n")

val strn = readFileIntoString("build.sbt")

println(strn)


// Listing 9.2 Several uses of import

import scala.concurrent.duration._                  // import everything from s.c.d
import scala.concurrent.duration.FiniteDuration     // imports class FiniteDuration from s.c.d
import scala.concurrent.duration.Duration.Inf       // imports the value Inf from s.c.d
import scala.concurrent.duration.Duration.create    // imports the function create from s.c.d.D 
import scala.io.{Source => Src}                     // imports Source and aliases it to Src
import scala.math.{BigDecimal, BigInt}              // imports BigDecimal and BigInt 


/// 9.2 Create a package

// Listing 9.3 Creating a package, my.example.io
//  File src/main/scala/my/example/io/MyExample.scala

import my.example.io.MyExample

val myexample = new MyExample()

val strn2 = myexample.readFileIntoString("build.sbt")
