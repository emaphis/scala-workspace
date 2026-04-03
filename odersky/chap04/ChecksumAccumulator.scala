// 4.1 Classes, fields, and methods

import scala.collection.mutable

// Listing 4.1 · Final version of class ChecksumAccumulator.
class ChecksumAccumulator:
  private var sum = 0
  def add(b: Byte): Unit = sum += b
  def checksum(): Int = ~(sum & 0xFF) + 1

// Listing 4.2 · Companion object for class ChecksumAccumulator.
object ChecksumAccumulator:
  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int =
    if cache.contains(s) then
      cache(s)
    else
      val acc = new ChecksumAccumulator
      for c <- s do
        acc.add((c >> 8).toByte)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs