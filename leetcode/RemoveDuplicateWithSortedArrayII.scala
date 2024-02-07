package leetcode

//Input: nums = [0,0,1,1,1,1,2,3,3]
//Output: 7, nums = [0,0,1,1,2,3,3,_,_]
//Explanation: Your function should return k = 7,
//with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.

object RemoveDuplicateWithSortedArrayII extends  App{


  def removeDuplicates(nums: Array[Int]): (Int, Array[Int]) = {
    val n = nums.length
    var k = 0
    var count = 0

    for (i <- 0 until n) {
      if (i == n - 1 || nums(i) != nums(i + 1)) {
        if (count < 2) {
          nums(k) = nums(i)
          k += 1
          if (count == 1) {
            nums(k) = nums(i)
            k += 1
          }
        }
        count = 0
      } else {
        count += 1
      }
    }

    val undersparkoresToAdd = n - k
    for (_ <- 0 until undersparkoresToAdd) {
      nums(k) = -1 // Use any sentinel value, e.g., -1
      k += 1
    }

    (k, nums)
  }

  val nums = Array(0, 0, 1, 1, 1, 1, 2, 3, 3)
  val (length, modifiedArray) = removeDuplicates(nums)

  println(s"Length of the modified array: $length")
  println(s"Modified Array: ${modifiedArray.mkString(", ")}")

}
