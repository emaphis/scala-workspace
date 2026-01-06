

final class Upper1$_ {
def args = Upper1_sc.args$
def scriptPath = """Upper1.sc"""
/*<script>*/
// src/script/scala/progscala3/introscala/Upper1.scala 

class Upper1:
    def convert(strings: Seq[String]) : Seq[String] =
        strings.map((s: String) => s.toUpperCase)

val up = new Upper1()
val uppers = up.convert(List("Hello", "Scala", "World!"))

println(uppers)

// Run as:1
// scala> :load src\script\scala\progscala3\introscala\Upper1.scala

/*</script>*/ /*<generated>*//*</generated>*/
}

object Upper1_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new Upper1$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export Upper1_sc.script as `Upper1`

