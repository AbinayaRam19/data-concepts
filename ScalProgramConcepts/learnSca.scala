package abiP

object learnsparka {


  def main(args: Array[String]): Unit = {

    val numList = List(1, 2, 3, 4, 5)
    println(numList.flatMap(a => a.to(a + 2)))
  }
  //OUTPUT: List(1,2,3,2,3,4,3,4,5,4,5,6,5,6,7)

}
