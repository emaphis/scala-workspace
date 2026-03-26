// src/main/scala/progscala3/typelessdomore/shapes.worksheet.sc

// Method Declarations

// Method Default and Named Parameters

case class Point(x: Double = 0.0, y: Double = 0.0):
    def shift(deltaX: Double, deltaY: Double): Point =
        copy(x = x + deltaX, y = y + deltaY)

val p1 = Point(x = 3.3, y = 4.4)
val p2 = p1.copy(y = 6.6)


// Methods with Multiple Parameter Lists

abstract class Shape:
    def draw(offset: Point  = Point(0.0, 0.0)) (f: String => Unit): Unit =
        f(s"Draw: offset = $offset, shape = ${this}")

case class Circle(center: Point, radius: Double) extends Shape

case class Rectangle(lowerLeft: Point, height: Double, width: Double) extends Shape

case class Triangle(point1: Point, point2: Point, point3: Point) extends Shape

val c = Circle(Point(1.0, 2.0), 3.0)
c.draw(Point(0.5, 0.5)) { msg => println(msg) } 

c.draw(Point(1.0, 2.0)) { msg => println(msg) }
c.draw(Point(1.0, 2.0)) { println }
