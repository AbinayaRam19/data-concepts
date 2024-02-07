package abiP

object RelativeSort {


  def main(args: Array[String]): Unit = {

    println("Enter the lenght of the array A and B respectively")
    var arrayALength = scala.io.StdIn.readInt()
    var arrayBLength = scala.io.StdIn.readInt()

    if (arrayBLength > arrayALength) {
      println("Array B lenght should be smaller than or equal to array length A")

    }
    else {

      val arrayA = new Array[Int](arrayALength)

      println("Enter elements of array A")
      for (i <- 0 until arrayALength) {
        arrayA(i) = scala.io.StdIn.readInt()
      }

      val arrayB = new Array[Int](arrayBLength)
      println("Enter elements of array B")
      for (i <- 0 until arrayBLength) {
        arrayB(i) = scala.io.StdIn.readInt()
      }

      println("array A : " + arrayA.length)
      println("array B : " + arrayB.length)


      var finalArray: Array[Int] = Array.empty
      for (eleB <- arrayB) {

        for (eleA <- arrayA) {
          {

            if (eleB == eleA) {
              finalArray = finalArray :+ eleA
            }
          }
        }
      }

      println("print the array below")
      finalArray.foreach(print)

      println("below is the sub array")
      var subArray: Array[Int] = Array.empty
      arrayA.foreach { a =>
        if (!arrayB.contains(a))
          subArray = subArray :+ a
      }
      subArray = subArray.sorted

      subArray.foreach(print)

      println("final array : " + (finalArray ++ subArray).mkString(" "))


    }
  }

}
