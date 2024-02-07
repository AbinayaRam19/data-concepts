package Test

object InfyTest extends App {



  var a = List(1,2,3,5)
  a.map(a => a+2).filter(a => a % 2 == 0)

  def testFunc(numbers: List[Int], f:Int => Int)={

    numbers.map(f)

  }

  def square(x :Int) = x * x
  println("test : " +testFunc(a,square))




}
