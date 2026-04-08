// Chapter 9
// Control Abstraction

// 9.4 Writing new control structures

import java.io.PrintWriter
import java.io.File

// Listing 9.4 · Using the loan pattern to write to a file.
object WithPrintWriter2 {

  def withPrintWriter(file: File) (op: PrintWriter => Unit) =
    val writer = new PrintWriter(file)
    try op(writer)
    finally writer.close()

  def main(args: Array[String]): Unit = {
    val file = new File("date.txt")

    withPrintWriter(file) { writer =>
      writer.println(new java.util.Date)
    }
  }
}
