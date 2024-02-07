package abiP

object BasicTests extends App {


  //def main(args: Array[String]): Unit = {

  var aList = Array("a", "b", "v")

  aList(2) = "c"
  println(aList)

  val a = Map('a' -> 'b').toList

  // val a: String = "baz"
  val array: Double = (Math.floor(3.1415)) * 2

  println(array)

  val aaa = Map("a" -> "b")
  println("get : " + (List('a') :: List('c')))


  val (arrays, nonArrays) = Array("a", "b", Array(1, 2, 3), "c")
    .zip(Stream from 5)
    .partition {
      case (a: Array[_], _) => true
      case _ => false
    }

  arrays.foreach {
    case (array, index) =>
      println(s"Array length at index $index is ${array.asInstanceOf[Array[Int]].length}")
  }

  println("case object value is "+Car.carNum)
  //}


}
