// Chapter 7
// Built-in Control Structures
// 7.3 For expressions

package chap07

object UseFiles:
  def main(args: Array[String]): Unit =
    Files.printFiles()
    Files.printFilesIter()
    Files.printScalaFiles()
    Files.printScalaFiles2()
    Files.printScalaFiles3()
    Files.grep(".*gcd.*")
    Files.grep2(".*gcd.*")
    println("Files.scalaFiles.toList [" + Files.scalaFiles.toList + "]")
    println("Files.forLineLengths.toList [" + Files.forLineLengths.toList + "]")
