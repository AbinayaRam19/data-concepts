package abiP

object curryingDemo {


  def main(args: Array[String]): Unit = {

    //println(add(5)(4))
    val a = add(5) _
    val b = a(6)(5)

    println("a is : " + a)

    println("value of b is " + b)
  }

  def add(a: Int)(b: Int)(c: Int): Int = {
    a + b + c
  }
}
