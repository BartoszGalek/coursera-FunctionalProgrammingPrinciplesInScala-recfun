package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      //pascal(x,x) == 1
      //pascal(0,?) == 1
      if (c!=0 && c != r) {
        //get row above elements and add their pascals
        pascal(c-1,r-1) + pascal(c,r-1)
      } else {
        1
      }
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      /*val lastOpenIdx:Int = chars.lastIndexOf('(')
      val ending = if (lastOpenIdx >0 )chars.slice(lastOpenIdx+1,chars.size) else List()
      val firstCloseFitIdx: Int = ending.indexOf(')')
      //if there's no bracket return true
      if (lastOpenIdx < 0 || firstCloseFitIdx < 0) {
        false
      } else {
        val remainingChars: List[Char] = ending.slice(firstCloseFitIdx+1, ending.length)

        val startingChars: List[Char] = chars.slice(0,lastOpenIdx)//know where is that last element
        val list: List[Char] = startingChars ++ remainingChars
        balance(list)
      }*/
      if (chars.nonEmpty && chars.contains('(')) {
        //first find last opening sign
        val endingChars: List[Char] = chars.slice(chars.lastIndexOf('(')+1,chars.size)
        if (endingChars.nonEmpty && endingChars.contains(')')) {
          val remainingChars: List[Char] = endingChars.slice(endingChars.indexOf(')')+1, endingChars.length)

          val startingChars: List[Char] = chars.slice(0,chars.lastIndexOf('('))//know where is that last element
          balance(startingChars ++ remainingChars)
          //from that place find the first closing bracket
          //rerun on the list without brackets and elements between
        } else {
          false
        }

      } else {
        !chars.contains(')')
      }
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      val operableCoins = coins.sortWith(_<_)
      //if there's no money ways is zero
      //if there's no coins ways is zero
      if (money <= 0 || operableCoins.isEmpty) {
        0
      } else {
        if (money -operableCoins.head ==0) {
          1
        } else countChange(money-operableCoins.head, operableCoins) +
        countChange(money, operableCoins.slice(1,operableCoins.size))
      }
    }
  }