package abiP

object lastElement {


  def main(args: Array[String]): Unit = {

    val listT = List(1, 4, 5, 6, 7, 7, 9)

    println("printing the last element: " + lastEle(listT))

    def lastEle(listT: List[Int]): Int = {

      var lastValue = 0

      def findLat(listT: List[Int], index: Int): Int = {

        if (Nil != listT(index)) {
          findLat(listT, index + 1)
        }
        else {
          lastValue = listT(index)
        }
        lastValue
      }

      findLat(listT, 0)
    }

  }
}
