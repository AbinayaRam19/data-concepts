package abiP

import scala.annotation.tailrec

object RecAndTailRec2 {


  def main(args: Array[String]): Unit = {


    println(recFun(3))
    println(tailRecFun(3))
  }


  def recFun(n: Int): Int = {

    if (n == 1) 1
    else recFun(n - 1) + n
  }

  def tailRecFun(n: Int): Int = {

    @tailrec
    def tailRec(n: Int, res: Int): Int = {

      if (n == 1) res
      else tailRec(n - 1, res + n)
    }

    tailRec(n, 1)
  }

}
