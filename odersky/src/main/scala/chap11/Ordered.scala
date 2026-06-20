// Chapter 11
// Traits

// 11.2 Thin versus rich interfaces

package chap11

trait Ordered[T]:
  infix def compare(that: T): Int

  infix def <(that: T): Boolean = (this compare that) < 0
  infix def >(that: T): Boolean = (this compare that) > 0
  infix def <=(that: T): Boolean = (this compare that) <= 0
  infix def >=(that: T): Boolean = (this compare that) >= 0
