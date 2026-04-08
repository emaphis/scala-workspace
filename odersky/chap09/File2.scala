// Chapter 9
// Control Abstraction

package chap09

// 9.1 Reducing code duplication

object File2  {

  object FileMatcher:
    private val filesHere = new java.io.File(".\\chap07").listFiles

    def filesMatching(query: String,
                      matcher: (String, String) => Boolean) =

      for file <- filesHere if matcher(file.getName, query)
      yield file

    def filesEnding(query: String) =
      filesMatching(query, _.endsWith(_))

    def filesContaining(query: String) =
      filesMatching(query, _.contains(_))

    def filesRegex(query: String) =
      filesMatching(query, _.matches(_))

  def main(args: Array[String]): Unit = {
    println("FileMatcher.filesEnding(\"scala\").toList [" +
      FileMatcher.filesEnding("scala").toList + "]")
    println("FileMatcher.filesContaining(\"File\").toList [" +
      FileMatcher.filesContaining("File").toList + "]")
    println("FileMatcher.filesRegex(\".*Re.ex.*\").toList [" +
      FileMatcher.filesRegex(".*Re.ex.*").toList + "]")
  }
}
