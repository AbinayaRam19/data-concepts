package abiP

import scala.annotation.tailrec
import scala.util.control.Breaks.{break, breakable}

object ListRev {


  def main(args: Array[String]): Unit = {

    var lis: List[Int] = List.empty


    println("enter the numbers of the list")


    var i = true

    breakable {
      while (i) {
        var a = scala.io.StdIn.readInt()
        if (a == 0) {
          println("end of list")
          break()
        }
        else lis = lis :+ a
      }
    }

    //lis.foreach(print)


    val rever = reverseA(lis)

    //val rev = reverseTail(lis)

    //println(rev + " @@ " + lis.reverse)

    println("rever : "+rever)
  }

  def reverseA[A](inputList: List[A]): List[A] = inputList match {
    case head :: tail =>{

      println("tail "+tail+ "head "+List(head))
      reverseA(tail) ::: List(head)

    }
    case Nil => Nil
  }

  def reverseTail[A](inputList: List[A]): List[A] = {
    @tailrec
    def reverse(reversedList: List[A], remainingList: List[A]): List[A] = remainingList match {
      case Nil => reversedList
      case head :: tail => reverse(head :: reversedList, tail)
    }

    reverse(Nil, inputList)
  }
}
