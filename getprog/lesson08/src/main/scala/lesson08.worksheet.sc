// Leeson 8 - Vending Machine

// Listing 8.1 The VendingMachine class
class VendingMachine {
  
    var chocolateBar = 0
    var granolaBar = 0

    var totalMoney = 0.0

    // Listing 8.2 API for VendingMachine

    def buy(product: String, money: Double): String = 
        // Listing 8.4 Implementation of function buy for VendingMachine
        if (!isProductAvailable(product))
            s"Sorry, produce $product is not available"
        else if(!isMoneyEnough(product, money))
            "Please insert more money"
        else completeRequest(product, money)

    // Listing 8.3 Main operations for VendingMachine
    
    // - Listing 8.5 Implementing checks for VendingMachine
    def isProductAvailable(product: String): Boolean =
        val productQuantity =
            if (product == "chocolate") chocolateBar
            else if (product == "granola") granolaBar
            else 0
        productQuantity > 0

    def isMoneyEnough(product: String, money: Double): Boolean =
        val cost = if (product == "chocolate") 1.5 else 1.0
        money >= cost

    // Listing 8.6 Implementing completeRequest for VendingMachine
    def completeRequest(product: String, money: Double): String =
        collectMoney(money)
        releaseProduct(product)
        s"There you go! Have a $product bar"

    def collectMoney(money: Double) =
        totalMoney += money

    def releaseProduct(product: String) =
        if (product == "chocolate") chocolateBar -= 1
        else if (product == "granola") granolaBar -= 1
}


/// 8.1.3 Let’s try it out

val machine = new VendingMachine()

machine.buy("chocolate", 1.5)

machine.chocolateBar

machine.granolaBar

// Let’s add two chocolate bars and one granola to the machine:
machine.chocolateBar += 2
machine.granolaBar += 1

// now try again
machine.buy("chocolate", 1.5)

machine.buy("chocolate", 1)

machine.buy("granola", 2)

machine.buy("granola", 2)

machine.totalMoney


/// 8.2 Possible improvements to our solution

// Everything is accessible

// Vars are probamatic

// Strins as the representation of the product

// String as the return type

// The Vendingmachine is not configurableS
