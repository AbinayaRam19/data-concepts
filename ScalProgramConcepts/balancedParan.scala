package abiP

import scala.annotation.tailrec

object balancedParan {

  def main(args: Array[String]): Unit = {
    println(balance("()()".toList))
  }

  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def check(sparkore: Int, chars: List[Char]): Int = {
      if (chars.isEmpty || sparkore < 0) {
        println("1st: "+chars.mkString(" ")+"sparkore: "+sparkore)
        sparkore
      } else if (chars.head == '(') {
        println("2 : "+chars.mkString(" ")+"sparkore: "+sparkore)
        check(sparkore + 1, chars.tail)
      } else if (chars.head == ')') {
        println("3 : "+chars.mkString(" ")+"sparkore: "+sparkore)
        check(sparkore - 1, chars.tail)
      } else {
        println("4 : "+chars.mkString(" ")+"sparkore: "+sparkore)
        check(sparkore, chars.tail)
      }
    }

    println("0 : "+chars.mkString(" "))
    0 == check(0, chars)
  }

}
