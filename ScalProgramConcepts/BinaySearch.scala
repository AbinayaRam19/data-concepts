package abiP

import scala.annotation.tailrec

object BinaySearch {
  def main(args: Array[String]): Unit = {


    println("val is " + binarySearch_tailRec(Array(10, 11, 12, 13, 14), 14))

    def binarySearch_tailRec(arr: Array[Int], target: Int): Int = {
      @tailrec
      def bs_helper(arr: Array[Int], target: Int, start: Int, end: Int): Int = {
        if (start > end) return -1
        val mid = start + (end - start) / 2
        println("mid: " + mid)
        arr(mid) match {
          case i if (i == target) => mid
          case i if (target < i) => bs_helper(arr, target, start, mid - 1)
          case _ => bs_helper(arr, target, mid + 1, end)
        }
      }

      bs_helper(arr, target, 0, arr.length - 1)
    }
  }


}
