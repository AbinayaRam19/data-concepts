package abiP

import java.io._
import scala.io._

object Result {

  /*
   * Complete the 'diagonalDifference' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY arr as parameter.
   */


  /*
  1 2 3  a [0][0]  [0][1] [0][2]
  4 5 6   [1][0]  [1][1] [1][2]
  7 8 9    [2][0]  [2][1] [2][2]
   */

  def diagonalDifference(arr: Array[Array[Int]]): Int = {
    // Write your code here

    var i = 0
    var j = 0
    var k = 0
    var l = 2

    var lefD: Array[Int] = Array.empty
    var rigD: Array[Int] = Array.empty

    while (i < arr.length) {
      while (j < arr.length) {
        lefD = lefD :+ arr(i)(j)
        i = i + 1
        j = j + 1
      }
    }

    while (k < arr.length) {
      while (l < arr.length) {
        rigD = rigD :+ arr(i)(j)
        k = k + 1
        l = l - 1
      }
    }

    var lSum = lefD.sum
    var RSum = rigD.sum

    lSum - RSum
  }

}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = StdIn.readLine.trim.toInt

    val arr = Array.ofDim[Int](n, n)

    for (i <- 0 until n) {
      arr(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    }

    val result = Result.diagonalDifference(arr)

    printWriter.println(result)

    printWriter.close()
  }
}
