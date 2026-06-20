// Chapter 16
// Mutable Objects

// 16.1 What makes an object mutable?

package chap16

class Keyed:
  def computeKey: Int = {
    Thread.sleep(1000)
    123
  }

// Can be faster because results are stored in a chache
// for later use.
class MemoKeyed extends Keyed:
  private var keyCache: Option[Int] = None
  override def computeKey: Int =
    if keyCache.isEmpty then
      keyCache = Some(super.computeKey)
    keyCache.get


object Ex03:

  def main(args: Array[String]): Unit = {
    println("Example 03")
    val memoKeyed = new MemoKeyed
    val keyed = new Keyed

    println("start...");
    println("keyed.computeKey [" + (keyed.computeKey) + "]")
    println("memoKeyed.computeKey [" + (memoKeyed.computeKey) + "]")
    println("memoKeyed.computeKey [" + (memoKeyed.computeKey) + "]")
  }
