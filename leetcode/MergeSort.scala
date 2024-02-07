package leetcode

object MergeSort {
  def mergeSort(arr: Array[Int]): Array[Int] = {
    def merge(left: Array[Int], right: Array[Int]): Array[Int] =
      if (left.isEmpty) right
      else if (right.isEmpty) left
      else if (left.head < right.head) left.head +: merge(left.tail, right)
      else right.head +: merge(left, right.tail)

    val n = arr.length / 2
    if (n == 0) arr
    else {
      val (left, right) = arr.splitAt(n)
      merge(mergeSort(left), mergeSort(right))
    }
  }

  def main(args: Array[String]): Unit = {
    val inputArray = Array(5, 3, 9, 1, 7)
    val sortedArray = mergeSort(inputArray)

    println(s"Input Array: ${inputArray.mkString(", ")}")
    println(s"Merge Sorted Array: ${sortedArray.mkString(", ")}")
  }
}