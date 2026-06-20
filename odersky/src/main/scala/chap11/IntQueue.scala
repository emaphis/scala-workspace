// Chapter 11
// Traits

// 11.3 Traits as stackable modifications

package chap11

// Listing 11.5 · Abstract class IntQueue.
abstract class IntQueue:
  def get(): Int
  def put(x: Int): Unit
