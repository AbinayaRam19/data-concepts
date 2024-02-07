package leetcode

object TwoSum extends App{


  def findSum (listOfInt: List[Int], target :Int)={


    val result = listOfInt.combinations(2).filter{case List(x, y) => x + y == target}.next()

    println("result "+result.foreach(println))
    println("zip with index"+ listOfInt.zipWithIndex.toMap)
    val indices = result.map(listOfInt.zipWithIndex.toMap)

    println("indices "+indices.foreach(println))

    var resultList  = List.empty[Int]
    var tempList = List.empty[Int]

    for (i <- 0 until listOfInt.length){
      for (j <- i + 1 until (listOfInt.length)){

        if (listOfInt(i) + listOfInt(j) == target){

          println("list i, j "+listOfInt(i)+ " + "+ listOfInt(j))
          tempList = tempList :+ i
          tempList = tempList :+ j

          println("tempList "+tempList.foreach(println))
          resultList = resultList.:::(tempList)
          println("resultList "+resultList.foreach(println))

        }

      }
    }
    resultList
  }





  println("indices: "+findSum(List(1,3,4,5),8))




}
