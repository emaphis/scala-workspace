// Default Parameter Values

// Scala provides the ability to give parameters default values that can be used to allow a caller to omit those parameters.

def log(message: String, level: String = "INFO") =
    println(s"$level: $message")

log("System starting")
log("User not found", "WARNING")


class Point(val x: Double = 0, val y: Double = 0)

val point1 = new Point(y = 1)

// Default Parameters for Overloaded Methods

//object A:
//    def func(x: Int = 34): Unit = println(s"x = $x")
//    def func(y: String = "abc") = println(s"y = $y")
