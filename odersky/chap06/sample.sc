
val x, y = 1
x + y
x - y

import scala.collection.immutable.ArraySeq

val arraySeq: ArraySeq[Int] = ArraySeq.from(0 to 9)

arraySeq.foreach { i =>
  println(s"i $i")
}
