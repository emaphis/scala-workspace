// Try This - Lesson 7

/*
TRY THIS A bar serves cold and hot beverages. You can request to add more
ice to a cold drink or to reheat a hot one. Express these relations using classes
and subclasses. 
 */

 abstract class Beverage(var temperature: Int)

 class ColdBeverage(temperature: Int) extends Beverage(temperature) {
    def addMoreIce = temperature -= 5
 }

 class HotBeverage(temperature: Int) extends Beverage(temperature) {
    def reheat = temperature += 5
 }

// testing
 
 val coke = ColdBeverage(10)
 coke.addMoreIce
 coke.temperature == 5

 val coffee = HotBeverage(100)
 coffee.reheat
 coffee.temperature == 105
