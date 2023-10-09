/*
TRY THIS Write a function to apply the discount to a given price as follows:
   0% discount if the price is less than $50
   10% discount if the price is at least $50 but less than $100
   15% discount if the price is at least $100
*/

def discount(price: Double): Double =
     val discount =
          if (price < 50.0) 0.0
          else if (price >= 50 && price <= 100.0) 0.10
          else  0.15  // cost > 100
     price * (1.0 - discount)

println(discount(20.0))
println(discount(50.0))
println(discount(60.0))
println(discount(100.0))
