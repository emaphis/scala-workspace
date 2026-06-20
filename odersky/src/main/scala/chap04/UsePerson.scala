object UsePerson {
  def main(args: Array[String]): Unit = {
    val p = Person("Sally", 39)
    println("Person = " + p)
    println("Name = " + p.name +", Age = " + p.age)

    val q = Person("sally", 39)
    println("Person = " + q)
    val r = q.appendToName(" Smith")
    println("Person = " + r)
  }
}
