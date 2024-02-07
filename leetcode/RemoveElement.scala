package leetcode



//Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
//  The order of the elements may be changed.
//Then return the number of elements in nums which are not equal to val


//Input: nums = [0,1,2,2,3,0,4,2], val = 2
//Output: 5, nums = [0,1,4,0,3,_,_,_]
//Explanation: Your function should return k = 5,
// with the first five elements of nums containing 0, 0, 1, 3, and 4.


object RemoveElement extends App {

  def removeElement(nums: Array[Int], value: Int): Unit = {
    var k = 0
    for (i <- 0 until nums.length) {
      if (nums(i) != value) {
        nums(k) = nums(i)
        k = k + 1
      }
    }

    // Resize the array to the correct length
    val result = nums.take(k)

    println(s"Length of the array without the value $value is ${result.length}")
    println(s"Array values without $value is ${result.mkString(", ")}")
  }

  removeElement(Array(1, 2, 3, 3), 2)

  }
