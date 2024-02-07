package leetcode


//
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.

object MaxProfit extends App{

  println(" find max profit :" +findMaxProfit(Array(7,1,5,3,6,4)))

  println(" find max profit :" +findMaxProfit(Array(7,6,4,3,1,9,10,4)))

  def findMaxProfit(prices: Array[Int]) = {

    var buy = Array.empty[Int]
    var sell = Array.empty[Int]
    var counter = 0

    for (i <- 0 until prices.length - 2){
      if (prices(i) > prices(i +1 ) && prices(i + 1) < prices(i + 2)) {
        buy = buy :+ prices(i + 1 )
        counter = -1
      }
      else if (prices(i) < prices(i +1 ) && prices(i + 1) > prices(i + 2))
        {
          sell = sell :+ prices(i + 1)
          counter = 1
        }

      else if (prices(i) > prices (i +1) &&  prices (i +1) > prices (i +2)){
        counter = 2
      }
    }

    if (counter == -1 || counter == 2) 0 else  (sell.last - buy(0))

  }


}
