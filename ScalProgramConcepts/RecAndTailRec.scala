package abiP

import scala.annotation.tailrec

object RecAndTailRec {

  def tailRecFactorial(n: BigInt): BigInt = {
    @tailrec
    def factorialAcc(acc: BigInt, n: BigInt): BigInt = {
      if (n <= 1)
        acc
      else
        factorialAcc(n * acc, n - 1)
    }

    factorialAcc(1, n)
  }

  def recFactorial(n: BigInt): BigInt = {
    if (n <= 1)
      1
    else
      n * recFactorial(n - 1)
  }

  // Main method
  def main(args: Array[String]): Unit = {
    println(tailRecFactorial(3))
    println(recFactorial(3))
  }
}
