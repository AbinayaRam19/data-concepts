package abiP

object functions {

  //partial functions

  def main(args: Array[String]): Unit = {


    var a = (x: Int, y: Int) => x + y

    var result = a(5, _: Int)
    var finalresult = result(7)

    println("final: " + finalresult)


  }


}
