// Case Classes

//* Defining a case class *

case class Book(isbn: String)

val frankenstein = Book("978-0486282114")


// When you create a case class with parameters, the parameters are public vals.

case class Message(sender: String, recipient: String, body: String)

val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")

println(message1.sender)

//message1.sender = "travis@washington.us"  // does not compile


//* Comparison *

//nInstances of case classes are compared by structure and not by reference:

//case class Message(sender: String, recipient: String, body: String)

val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
val messagesAreTheSame = message2 == message3


//* Copying *
// ou can create a (shallow) copy of an instance of a case class simply by using the copy method. You can optionally
// change the constructor arguments.

//case class Message(sender: String, recipient: String, body: String)

val message4 = Message("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")

message5.sender
message5.recipient
message5.body
