// Lesson 10  -- Scope Your Code with Access Modifiers


/// 10.1 Public, the default access modifier

// Listing 10.1 The class Party

class Party1 {
    var attendees = 0     // public by default

    def register(guests: Int) =
        attendees += guests
}

val party1 = new Party1()
party1.register(10)  // ok
party1.attendees += 3   // opps!
party1.attendees

// public val a = "Hello"   // 'public' keyword doesn't exist in scala - default
val b = "world"


// 10.2 Private

// Listing 10.2 The class Party, where attendees are private

class Party2 {
    private var attendees = 0     // inaccessable from outside the class

    def register(guests: Int) =
        attendees += guests
}

val party2 = new Party2()
party2.register(10)  // ok
//party2.attendees += 3   // won't compile
//party2.attendees   // 


// Listing 10.3 Defining a class Test

class Test {
    val configA = "I am public"
    private val configB = "I am private"
}

val test = new Test

test.configA
//test.configB   // wont compile


// 10.3 Protected

// Listing 10.4 The class Event

class Event4 {
    protected def estimatedCosts(attendees: Int): Double =
        if (attendees < 10) 50.00 else attendees * 12.34
}

class Party4 extends Event4 {
    private var attendees = 0

    // should be a `def`
    def cost = estimatedCosts(attendees)

    def register(guests: Int) =
        attendees += guests
}

val party4 = new Party4()
party4.register(9)
party4.cost == 50.0
party4.register(10)
party4.cost == 234.46
