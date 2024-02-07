package abiP

object BubbleSort extends App {
  def bubbleSort(arr: Array[Int]): Unit = {
    val n = arr.length
    for (i <- 0 until n - 1) {
      for (j <- 0 until n - i - 1) {
        if (arr(j) > arr(j + 1)) {
          // swap arr(j) and arr(j+1)
          val temp = arr(j)
          arr(j) = arr(j + 1)
          arr(j + 1) = temp
        }

      }
    }
  }

  val number = 958

  // Convert number to an array of digits
  var digits = Array[Int]()
  var tempNumber = number
  while (tempNumber > 0) {
    digits = (tempNumber % 10) +: digits
    tempNumber /= 10
  }

  // Sort the array using bubble sort
  bubbleSort(digits)
println("digits "+digits.foreach(println))
  // Convert the sorted array back to a number
  var result = 0
  for (digit <- digits) {
    result = result * 10 + digit
  }

  println(result)


}


