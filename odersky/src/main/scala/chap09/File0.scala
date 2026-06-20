// Chapter 9
// Control Abstraction

package chap09

// 9.1 Reducing code duplication

object File0  {

  object FileMatcher:
   //private def filesHere = (new java.io.File(".//chap08")).listFiles
    private val filesHere = new java.io.File(".\\chap07").listFiles

    private def filesMatching(matcher: String => Boolean) =
      for file <- filesHere if matcher(file.getName)
        yield file

    def filesEnding(query: String) =
      filesMatching(_.endsWith(query))

    def filesContaining(query: String) =
      filesMatching(_.contains(query))

    def filesRegex(query: String) =
      filesMatching(_.matches(query))

  def main(args: Array[String]): Unit = {
    println("FileMatcher.filesEnding(\"scala\").toList [" +
      FileMatcher.filesEnding("scala").toList + "]")
    println("FileMatcher.filesContaining(\"Files\").toList [" +
      FileMatcher.filesContaining("Files").toList + "]")
    println("FileMatcher.filesRegex(\".*Re.ex.*\").toList [" +
      FileMatcher.filesRegex(".*Re.ex.*").toList + "]")
  }
}
