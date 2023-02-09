object MainI {

  /** Tuples */
  def f1() = {
    val tuple1 = new Tuple1("sth")
    println(tuple1._1)

    println()

    val tuple2 = (1337, "one three seven")
    println(tuple2._1)
    println(tuple2._2)

    println()

    val swapped =tuple2.swap
    println(swapped._1)
    println(swapped._2)

    println()
    
    val tuple3 = (1337, "one three seven", 'c')
    println(tuple3._1)
    println(tuple3._2)
    println(tuple3._3)
  }

  /** Case classes and companion objects */
  object StringWithLength {
    def apply(string: String): StringWithLength =
      new StringWithLength(string)
  }

  final case class StringWithLength(val string: String) {
    val length: Int = string.length

    def +(that: StringWithLength): StringWithLength = 
      StringWithLength(this.string + that.string)
  }
  
  def f2() = {
    val result: StringWithLength =
      StringWithLength("hello") + StringWithLength("world")
    
    println(result)
    println(result.string)
    println(result.length)

    println("\nHello")
  }

  /**
    * More case classes
    */
  def f() = {
    final case class Person(
      name: String,
      age: Int,
      phone: String,
      email: String
    )

    val bob =
      Person(
        name = "Bob",
        age = 20,
        phone = "1-111-222-3333",
        email = "go@gmail.com"
      )

    println(bob)
    println("\nHello")
  }

  /** main program */
  def mainI(args: Array[String]): Unit = {
    println("-" * 50)
    f()
    println("-" * 50)
  }
}
