// Classes

//* Defining a class *


class User

val user1 = User()

// User has a default constructor which takes no arguments because no constructor was define
// However, you’ll often want a constructor and class body.

class Point(var x: Int, var y: Int):

    def move(dx: Int, dy: Int): Unit =
        x = x + dx
        y = y + dy

    override def toString(): String =
        s"($x, $y)"
end Point

val point1 = Point(2, 3)
println(point1.x)
println(point1.y)
println(point1)


//* Constructors *

// Constructors can have optional parameters by providing a default value like so:

class Point2(var x: Int = 0, var y: Int = 0):
    override def toString(): String =
        s"($x, $y)"

val origin = Point2()
println(origin)
val point2 = Point2(2)
println(point2)

// Passing named parameters. 
val point3 = Point2(y = 3)
println(point3)


// * Private Members and Getter/Setter Syntax *

class Point3:
    private var _x = 0
    private var _y = 0
    private  val bound = 100

    def x: Int = _x
    def x_=(newValue: Int): Unit =
        if newValue < bound then
            _y = newValue
        else
            printWarning()

    def y: Int = _y
    def y_=(newValue: Int): Unit =
    if newValue < bound then
      _y = newValue
    else
      printWarning()

    private def printWarning(): Unit =
        println("WARNING: Out of bounds")
end Point3

val point4 = Point3()
point4.x = 99
point4.y = 101

// But

class Point4(val x: Int, val y: Int)
val point5 = Point4(1, 2)
//point5.x = 3  // does not compile

// Parameters without val or var are private values, visible only within the class.

class Point5(x: Int, y: Int)
val point6 = Point5(1, 2)
//point6.x  // Does not compile
