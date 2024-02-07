package abiP

import scala.annotation.tailrec

object FuncProgramPrinciple {


  @tailrec
  def logElements(lst: List[String]): Unit = lst match {
    case head :: tail =>
      println(head)
      logElements(tail)
    case Nil =>
  }

  val arr: List[String] = List("banana", "orange", "apple")

  println("Before sorting:")
  logElements(arr)

  private val sortedArr = arr.sorted

  println("After sorting:")
  logElements(sortedArr)
}
