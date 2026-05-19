// Chapter 17
// Scala’s Hierarchy

// 17.1 Scala’s class hierarchy

//new Int
//Int is abstract; it cannot be instantiated

//val i: Int = null
// Required: Int

//  Any has two subclasses: AnyVal and AnyRef


//class Dollars(val amount: Int) extends AnyVal:
//  override def toString: String = "$" + amount

//class SwissFranks(val amount: Int) extends AnyVal:
//  override def toString: String = s"$amount CHF"

//val dollars = Dollars(1000)
//val franks = SwissFranks(1000)

// Valueclassesalsoinherit allmethodsfromclassAny

42.toString   // "42"
42.hashCode   // 42
42.equals(42) // true

42.max(43)    // 43
42.min(43)    // 42
1 until 5     // Range 1until 5
1 to 5        // Range 1 to 5
3.abs         // 3
-3.abs        // 3




