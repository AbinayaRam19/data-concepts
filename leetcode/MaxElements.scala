package leetcode

object MaxElements extends App {

  val ar = Array(2, 3, 3, 3, 6,6)
  majorityElement(ar)

  def majorityElement(nums: Array[Int]) = {


    val arraySize = nums.length
    val occurenceCheck = arraySize / 2

    var a = nums.map(x => (x, 1))
      .groupBy(_._1).mapValues(_.length)

    var resul = a.filter(num => num._2 >= occurenceCheck).keys

    println("result " + resul)

  }

}
