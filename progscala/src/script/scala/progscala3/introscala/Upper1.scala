
// src/script/scala/progscala3/introscala/Upper1.scala

class Upper1 {
    def convert(strings: Seq[String]) : Seq[String] =
        strings.map((s: String) => s.toUpperCase
}
val up = new Upper1()
val uppers = up.convert(List("Hello", "Scala", "World!"))

println(uppers)

// Run as:1
// scala> :load src\script\scala\progscala3\introscala\Upper1.scala
