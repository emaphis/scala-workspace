// Chapter 11
// Traits

// 11.3 Traits as stackable modifications

package chap11

import scala.collection.mutable.ArrayBuffer

object Ex02:

  // Listing 11.6 · A BasicIntQueue implemented with an ArrayBuffer.
  class BasicIntQueue extends IntQueue:
    private val buffer = ArrayBuffer.empty[Int]
    override def get(): Int = buffer.remove(0)
    override def put(x: Int): Unit = buffer += x

  // Listing 11.7 · The Doubling stackable modification trait.
  trait Doubling extends IntQueue:
    abstract override def put(x: Int): Unit = super.put(2 * x)

  class MyQueueD extends BasicIntQueue, Doubling

  // Listing 11.9 · Stackable modification traits Incrementing and Filtering.
  trait Incrementing extends IntQueue:
    abstract override def put(x: Int): Unit = super.put(x + 1)

  trait Filtering extends IntQueue:
    abstract override def put(x: Int): Unit =
      if x >= 0 then super.put(x)

  def main(args: Array[String]): Unit = {
    println("Basic Int Queue")
    val queue = BasicIntQueue()
    queue.put(10)
    queue.put(20)
    val num1 = queue.get()
    val num2 = queue.get()
    println(s"$num1 - $num2")

    println("Basic Int Queue with Doubling")
    val queueD = MyQueueD()
    queueD.put(10)
    queueD.put(20)
    val num3 = queueD.get()  // 20
    val num4 = queueD.get()  // 40
    println(s"$num3 - $num4")

    println("Basic Int Queue with Incrementing and Filtering")
    val queueIF = new BasicIntQueue with Incrementing with Filtering
    queueIF.put(-1)
    queueIF.put(0)
    queueIF.put(1)
    val num5 = queueIF.get() // 1
    val num6 = queueIF.get() // 2
    println(s"$num5 - $num6")

    println("Basic Int Queue with Filtering and Incrementing")
    val queueFI = new BasicIntQueue with Filtering  with Incrementing {}
    queueFI.put(-1)
    queueFI.put(0)
    queueFI.put(1)
    val num7 = queueFI.get() // 0
    val num8 = queueFI.get() // 1
    val num9 = queueFI.get() // 2
    println(s"$num7 - $num8 - $num9")
  }