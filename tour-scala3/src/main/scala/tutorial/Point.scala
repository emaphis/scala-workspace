//Default Parameter Values
package tutorial

class Point(val x: Int = 0, val y: Int = 0):
    override def toString: String = s"Point: (x=$x, y=$y)"
