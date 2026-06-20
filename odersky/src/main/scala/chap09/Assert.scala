// Chapter 9
// Control Abstraction

// 9.5 By-name parameters

object Assert {

    var assertionsEnabled = true

    def myAssert(predicate: () => Boolean): Unit =
      if assertionsEnabled && !predicate() then
        throw new AssertionError

    def byNameAssert(predicate: => Boolean) =
      if assertionsEnabled && !predicate then
        throw new AssertionError

    def main(args: Array[String]): Unit =
        try
            myAssert(() => 5 > 3)
            println("5 > 3 assertion passed")
            myAssert(() => 5 < 3)
            println("5 < 3 assertion passed")
        catch
            case ex: AssertionError => println("ex: [" + ex + "]")

        try
            byNameAssert(5 > 3)
            println("5 > 3 assertion passed")
            byNameAssert(5 < 3)
            println("5 < 3 assertion passed")
        catch
            case ex: AssertionError => println("ex: [" + ex + "]")

}
