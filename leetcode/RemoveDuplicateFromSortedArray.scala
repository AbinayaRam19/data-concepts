package leetcode


//Input: nums = [0,0,1,1,1,2,2,3,3,4]
//Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
//Explanation: Your function should return k = 5,
// with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).



object RemoveDuplicateFromSortedArray extends App {

  def removeDuplicates(nums: Array[Int]): Int = {
    var i = 0
    var j = 0
    val n = nums.length

    while (i < n - 1) {
      if (nums(i) != nums(i + 1)) {
        // Unique element found, copy it to nums(j)
        nums(j) = nums(i)
        j += 1
      }
      i += 1
    }

    // Copy the last unique element (or the only unique element)
    nums(j) = nums(n - 1)

    // Count of unique elements is j + 1
    j + 1
  }

  val nums = Array(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
  val uniqueCount = removeDuplicates(nums)
  val uniqueElements = nums.take(uniqueCount)

  println("Number of unique elements: " + uniqueCount)
  println("Unique elements: " + uniqueElements.mkString(", "))
}
