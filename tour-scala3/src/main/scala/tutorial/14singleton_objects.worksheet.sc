// Singleton Objects

// Defining a singleton object

object Box

// See: logging/Loger.scala

import logging.Logger.info

class Project(name: String, daysToComplete: Int)

class Test:
  val project1 = Project("TPS Reports", 1)
  val project2 = Project("Website redesign", 5)
  info("Created projects")

val test1 = Test()


//* Companion objects *
// An object with the same name as a class is called a companion object.

import scala.math.{Pi, pow}

case class Circle(radius: Double):
  import Circle.*
  def area: Double = calculateArea(radius)

object Circle:
  private def calculateArea(radius: Double): Double =
    Pi * pow(radius, 2.0)

val circle1 = Circle(5.0)

circle1.area


// The companion object can also contain factory methods

class Email(val username: String, val domainName: String)

object Email:
  def fromString(emailString: String): Option[Email] =
    emailString.split('@') match
      case Array(a, b) => Some(Email(a, b))
      case _ => None

val scalaCenterEmail = Email.fromString("scala.center@epfl.ch")
scalaCenterEmail match
  case Some(email) => println(
    s"""Registered an email
       |Username: ${email.username}
       |Domain name: ${email.domainName}
     """.stripMargin)
  case None => println("Error: could not parse email")
