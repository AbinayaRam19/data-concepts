package abiP

object SubArray {

  def main(args: Array[String]): Unit = {

    println("Enter the lenght of array and sum of elements")
    var arrayLength = scala.io.StdIn.readInt()
    var arraySum = scala.io.StdIn.readInt()


    var arrayA = new Array[Int](arrayLength)

    println("enter the array elements")
    for (i <- 0 until arrayLength) {
      arrayA(i) = scala.io.StdIn.readInt()
    }

    println("Array is :" + arrayA.mkString(" "))

    var counter = 0
    var subArray: Array[Int] = Array.empty
    for (i <- arrayA.indices) {


      println("counter 1: " + counter)

      if (counter == arraySum) {
        subArray = subArray :+ arrayA(i)
      }
      else if (counter < arraySum) {
        counter += arrayA(i)

        println("counter 2: " + counter)
        subArray = subArray :+ arrayA(i)
      }

    }
    print("final array " + subArray.mkString(" "))
  }
}
