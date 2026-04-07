// Chapter 8
// Functions and Closures
// 8.1 Methods

object Padding1:

  // Listing 8.1 · Padding with a private padLine method.
  def padLines(text: String, minWidth: Int): String =

    val paddedLines =
      for line <- text.linesIterator yield
        padLine(line, minWidth)
    paddedLines.mkString("\n")

  private def padLine(line: String, minWidth: Int): String =
    if line.length >= minWidth then line
    else line + " " * (minWidth - line.length)


object PadLines1 {
  def main(args: Array[String]): Unit =
    val width = args(0).toInt
    for (arg <- args.drop(1)) {
      val source = scala.io.Source.fromFile(arg)
      val content = try source.getLines.mkString("\n") finally source.close()
      print(Padding1.padLines(content, width))
    }
}
