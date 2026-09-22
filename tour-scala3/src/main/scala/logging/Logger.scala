// Singleton Objects
// Defining a singleton object

package logging

object Logger:
  def info(message: String): Unit = println(s"Info: $message")
