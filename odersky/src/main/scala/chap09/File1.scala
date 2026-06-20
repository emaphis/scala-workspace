// Chapter 9
// Control Abstraction

package chap09

// 9.1 Reducing code duplication

object File1  {

  object FileMatcher:
    private val filesHere = new java.io.File(".\\chap07").listFiles

    def filesEnding(query: String) =
      for file <- filesHere if file.getName.endsWith(query)
      yield file

    def filesContaining(query: String) =
      for file <- filesHere if file.getName.endsWith(query)
      yield file

    def filesRegex(query: String) =
      for file <- filesHere if file.getName.matches(query)
      yield file

  def main(args: Array[String]): Unit = {
    println("FileMatcher.filesEnding(\"scala\").toList [" +
      FileMatcher.filesEnding("scala").toList + "]")
    println("FileMatcher.filesContaining(\"File\").toList [" +
      FileMatcher.filesContaining("File").toList + "]")
    println("FileMatcher.filesRegex(\".*Re.ex.*\").toList [" +
      FileMatcher.filesRegex(".*Re.ex.*").toList + "]")
  }
}
