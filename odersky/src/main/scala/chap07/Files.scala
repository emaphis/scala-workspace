// Chapter 7
// Built-in Control Structures
// 7.3 For expressions

package chap07

import java.io.File

object Files:

  // Iteration through collections

  private val filesHere = new File(".\\chap07").listFiles

  // Listing 7.5 · Listing files in a directory with a for expression.
  def printFiles(): Unit =
    for file <- filesHere do
      println(file)

  // Calculating number of files in Array.  Common in Java
  def printFilesIter(): Unit =
    //for i <- 0 to filesHere.length- 1 do
    for i <- 0 until filesHere.length do
      println(filesHere(i))

  // Filtering

  // Listing 7.6 · Finding .scala files using a for with a filter.
  def printScalaFiles(): Unit =
    for file <- filesHere if file.getName.endsWith(".scala") do
      println(file)

  def printScalaFiles2(): Unit =
    for file <- filesHere do
      if file.getName.endsWith(".scala") then
        println(file)

  // Listing 7.7 · Using multiple filters in a for expression.
  def printScalaFiles3(): Unit =
    for
      file <- filesHere
      if file.isFile
      if file.getName.endsWith(".scala")
    do println(file)

  // Nested iteration

  // Listing 7.8 · Using multiple generators in a for expression.
  private def fileLines(file: java.io.File): Array[String] =
    val input = scala.io.Source.fromFile(file)
    input.getLines().toArray

  def grep(pattern: String): Unit =
    for
      file <- filesHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      if line.trim.matches(pattern)
    do println(s"$file: ${line.trim}")

  // Mid-stream variable bindings

  // Listing 7.9 · Mid-stream assignment in a for expression.
  def grep2(pattern: String): Unit =
    for
      file <- filesHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(pattern)
    do println(s"$file: ${line.trim}")


  // Producing a new collection

  def scalaFiles: Array[File] =
    for
      file <- filesHere
      if file.getName.endsWith(".scala")
    yield file

  // Listing 7.10 · Transforming an Array[File] to Array[Int] with a for.
  val forLineLengths: Array[Int] =
    for
      file <- filesHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(".*for.*")
    yield  trimmed.length
    