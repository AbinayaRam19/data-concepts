package leetcode

object RotateArray extends App{

   rotate(Array(1,2,3,4,5,6,7),3)
  def rotate(nums: Array[Int], k: Int): Unit = {

       var temp = 1
    var finalArray = Array.empty[Int]

    finalArray = nums
       while (temp <= k){
         val (firstPart, secondPart) = finalArray.splitAt(finalArray.length - 1)
         finalArray = secondPart ++ firstPart
         temp +=1
       }

println("final array "+finalArray.mkString(","))
  }
}
