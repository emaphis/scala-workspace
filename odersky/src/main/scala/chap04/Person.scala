// 4.4 Case classes

case class Person(name: String, age: Int):
  def appendToName(suffix: String): Person =
    Person(s"$name$suffix", age)

object Person:
  // Ensure non-empty name is capitalize
  def apply(name: String, age: Int): Person =
    val capitalizedName =
      if name.nonEmpty then
        val firstChar = name.charAt(0).toUpper
        val restName = name.substring(1)
        s"$firstChar$restName"
      else
        throw new IllegalArgumentException("Empty name")
    new Person(capitalizedName, age)
