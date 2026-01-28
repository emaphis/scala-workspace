package recfun

object RecFun extends RecFunInterface:


  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */
  def pascal(col: Int, row: Int): Int =
    if (col == 0 || col == row) then 1
    else pascal(col - 1, row - 1) + pascal(col, row - 1)



  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = 
    
    def loop(chars: List[Char], openCount: Int): Boolean =
      if chars.isEmpty then openCount == 0
      else if chars.head == '(' then loop(chars.tail, openCount + 1)
      else if chars.head == ')' then 
        if openCount > 0 then loop(chars.tail, openCount - 1)
        else false
      else loop(chars.tail, openCount)
    
    loop(chars, 0)


  /**
   * Exercise 3
   */  
  def countChange(money: Int, coins: List[Int]): Int =
    if money == 0 then 1
    else if money < 0 || coins.isEmpty then 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
