package abiP

import scala.annotation.tailrec

object Palindrome {

  def main(args: Array[String]): Unit = {

    var a = "manam"

    @tailrec
    def palindrome(str: String, start: Int, end: Int): Boolean = {
      if (start == end) {
        true
      }

      else if (str(start) != str(end)) {
        false
      } else
        palindrome(str, start + 1, end - 1)
    }

    println(palindrome(a, 0, a.length - 1))

  }
}
