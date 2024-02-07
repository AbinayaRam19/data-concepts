package abiP

import scala.annotation.tailrec

object bSearch {


  def main(args: Array[String]): Unit = {


    println("val is " + binarySearch_tailRec(Array(10, 11, 12, 13, 14), 15))


    def binarySearch_tailRec(ints: Array[Int], i: Int): Int = {

      @tailrec
      def bsearch(ints: Array[Int], i: Int, start: Int, end: Int): Int = {

        var mid = start + (end - start) / 2

        if (start > end) return -1

        ints(mid) match {
          case a if (a == i) => mid
          case a if (i > a) => bsearch(ints, i, mid + 1, end)
          case a if (i < a) => bsearch(ints, i, 0, mid - 1)
        }
      }

      bsearch(ints, i, 0, ints.length - 1)
    }
  }
}
