// Pattern Matching

// Syntax

import scala.util.Random

val x: Int = Random.nextInt(10)

x match
  case 0 => "zero"
  case 1 => "one"
  case 2 => "two"
  case 3 => "three"
  case 4 => "four"
  case _ => "other"


// Match expressions have a value.

def matchTest(x: Int): String = x match
  case 1 => "one"
  case 2 => "two"
  case _ => "other"

matchTest(3)
matchTest(1)


//* Match expressions have a value. *

// Case classes are especially useful for pattern matching.

sealed trait Notification

case class Email(sender: String, title: String, body: String) extends  Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification

// Notification is a sealed trait which has three concrete Notification types implemented with case classes Email, SMS, and VoiceRecording.
//  Now we can do pattern matching on these case classes:

def showNotification(notification: Notification): String =
  notification match
    case Email(sender, title, _) =>
      s"You got an email from $sender with title: $title"
    case SMS(caller, message) =>
      s"You got an SMS from $caller! Message: $message"
    case VoiceRecording(name, link) =>
      s"You received a Voice Recording from $name! Click the link to hear it: $link"

val someSms = SMS("12345", "Are you there?")
val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

println(showNotification(someSms))
println(showNotification(someVoiceRecording))


//* Matching on string *

val input: String = "Alice is 25 years old"

input match
  case s"$name is $age years old" => s"$name's age is $age"
  case _ => "No match"


// We can also use extractor objects for string pattern matching.

object Age:
  def unapply(s: String): Option[Int] = s.toIntOption

val (name, age) = input match
  case s"$name is ${Age(age)} years old" => (name, age)


//* Pattern guards

def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String =
  notification match
    case Email(sender, _, _) if importantPeopleInfo.contains(sender) =>
      "You got an email from special someone!"
    case SMS(caller, _) if importantPeopleInfo.contains(caller) =>
      "You got an SMS from special someone!"
    case other =>
      showNotification(other)

val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")

val someSms1 = SMS("123-4567", "Are you there?")
val someVoiceRecording1 = VoiceRecording("Tom", "voicerecording.org/id/123")
val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
val importantSms = SMS("867-5309", "I'm here! Where are you?")

println(showImportantNotification(someSms1, importantPeopleInfo))
println(showImportantNotification(someVoiceRecording1, importantPeopleInfo))
println(showImportantNotification(importantEmail, importantPeopleInfo))

println(showImportantNotification(importantSms, importantPeopleInfo))


//* Matching on type only

sealed trait Device

case class Phone(model: String) extends Device:
  def screenOff = "Turning screen off"

case class Computer(model: String) extends Device:
  def screenSaverOn = "Turning screen saver on ..."

def goIdle(device: Device): String = device match
  case p: Phone => p.screenOff
  case c: Computer => c.screenSaverOn

val computer = Computer("Dell")
val phone = Phone("IPhone")

println(goIdle(computer))
println(goIdle(phone))


//* Binding matched patterns to variables *

def goIdleWithModel(device: Device): String = device match
  case p @ Phone(model) => s"$model: ${p.screenOff}"
  case c @ Computer(model) => s"$model: ${c.screenSaverOn}"

println(goIdleWithModel(computer))
println(goIdleWithModel(phone))


//* Sealed types *
// Provides extra safety because the compiler checks that the cases of a match expression are exhaustive when the base type is sealed.

/*
def showNotification1(notification: Notification): String =
  notification match
    case Email(sender, title, _) =>
      s"You got an email from $sender with title: $title"
    case SMS(caller, message) =>
      s"You got an SMS from $caller! Message: $message"

  |  notification match
  |  ^^^^^^^^^^^^
  |  match may not be exhaustive.
  |
 */
