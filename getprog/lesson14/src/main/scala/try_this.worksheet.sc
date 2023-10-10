// Try This - Lesson 14

/*
    TRY THIS In lesson 5, you wrote a function to apply the discount to a given
    price as follows:

     0% discount if the price is less than $50
     10% discount if the price is at least $50 but less than $100
     15% discount if the price is at least $100

    Reimplement it using pattern matching instead of an if-else construct.
*/

def discount(price: Double) =
     val discount =
        price match
          case p if p < 50.0  => 0.0
          case p if p <= 100.0 => 0.10
          case _ =>  0.15  // cost > 100

     price * (1.0 - discount)


println(discount(20.0))
println(discount(50.0))
println(discount(60.0))
println(discount(200.0))
