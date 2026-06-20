// Chapter 12
// Packages, Imports, and Exports

// 12.7 Exports

case class PosInt(value: Int):
  require(value > 0)

  // def +(x: Int): Int = value + x
  export value.*
 // export value.{<< as shl, >> as shr, >>> as ushr, *}

val x1 = PosInt(99)
x1 + 1 // 100
x1 - 1 // 98
x1 / 3 // 33


val x2 = PosInt(24)
x2 << 1 // 48 (shift left)
x2 >> 1 // 12 (shift right)
x2 >>> 1 // 12 (unsigned shift right)


case class PosInt2(value: Int):
  require(value > 0)

  export value.{<< as shl, >> as shr, >>> as ushr, *}

val x3 = PosInt2(24)
x3 shl 1 // 48
x3 shr 1 // 12
x3 ushr 1 // 12

// x3 >>> 1
