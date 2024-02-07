package leetcode


// nums1.length == m + n
// nums2.length == n
// 0 <= m, n <= 200
// 1 <= m + n <= 200
// -109 <= nums1[i], nums2[j] <= 109  // Math.pow(-10, 9) <= nums1(i) &&  nums2(j) <= Math.pow(10,9)

object MergeSortArray extends App {

  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int) = {

    val nums3 = new Array[Int](m + n)
    if (nums1.length == m + n && nums2.length == n) {

      var i = 0
      var j = 0
      var k = 0

      while (i < m && n < 200 && nums1.length != 0 && nums2.length != 0) {
        if (nums1(i) <= nums2(j)) {
          nums3(k) = nums1(i)
          i = i + 1
        }
        else {
          nums3(k) = nums2(j)
          j = j + 1
        }
        k = k + 1
      }
      println("value of nums3(k) and j is "+k +" "+j)
      while (i < m ){

        nums3(k) = nums1(i)
        k = k + 1
        i = i + 1
      }

      while (j < n) {
        println("nums2(j ) " + nums2(j))
        nums3(k) = nums2(j)
        k = k + 1
        j = j + 1
      }
      nums3
    }
    else Array.empty[Int]
  }

  var array1 = Array(1)
  var array2 = Array.empty[Int]
  println(merge(array1, 1, array2, 0).mkString("Array(", ", ", ")"))

  var array3 = Array(1,2,3,0,0,0)
  var array4 = Array(2,5,6)
  println(merge(array3, 3, array4, 3).mkString("Array(", ", ", ")"))

  //  nums1 = [1], m = 1, nums2 = [], n = 0 OUTPUT: The result of the merge is [1].
}


