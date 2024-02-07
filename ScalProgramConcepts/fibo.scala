package abiP

object fibo {

  def main(args: Array[String]): Unit = {

println("fibo: "+fib1(4))

    def fib1(n: Int): Int = n match {
      case 0 | 1 => n
      case _ => fib1(n - 1) + fib1(n - 2)
    }
  }
}
