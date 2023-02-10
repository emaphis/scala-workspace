/*
TRY THIS Write a function to apply the discount to a given price as follows:
   0% discount if the price is less than $50
   10% discount if the price is at least $50 but less than $100
   15% discount if the price is at least $100
*/

def discount(cost: Double): Double =
    if (cost < 50.0)
         cost
    else if (cost >= 50 && cost <= 100.0)
         cost - (cost * 0.10)
    else  // cost > 100
        cost - cost - (cost * 0.15)

println(discount(20.0))
println(discount(50.0))
println(discount(60.0))
println(discount(100.0))
