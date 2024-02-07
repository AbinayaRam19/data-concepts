package leetcode

object QuickSort {
  def quickSort(arr: Array[Int]): Array[Int] = {
    if (arr.length <= 1) arr
    else {
      val pivot = arr(arr.length / 2)
      Array.concat(
        quickSort(arr.filter(_ < pivot)),
        arr.filter(_ == pivot),
        quickSort(arr.filter(_ > pivot))
      )
    }
  }

  def main(args: Array[String]): Unit = {
    val inputArray = Array(5, 3, 9, 1, 7)
    val sortedArray = quickSort(inputArray)

    println(s"Input Array: ${inputArray.mkString(", ")}")
    println(s"Quick Sorted Array: ${sortedArray.mkString(", ")}")
  }
}