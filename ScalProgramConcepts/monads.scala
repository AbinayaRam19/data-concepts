package abiP

object monads {


  def main(args: Array[String]): Unit = {

    val list1 = List(1, 2, 3, 4)
    val list2 = List(5, 6, 7, 8)

    var element = list1(1)
    println("element "+element)

    var z = list1.flatMap(q => list2.map(r => (q + r)))

    println(z)

    var y = 2

val res = list1.flatMap(x => x until  (x + y))
println(res)

    var result: List[Int]= Nil


     for(data <- list1){
      var rec = 1
      while(rec <= 2) {

        result = result :+ data
        rec+=1
      }
    }

    println("result "+result)
  }
}
