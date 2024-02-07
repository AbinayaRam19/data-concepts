package abiP

object ImplicitParameter {

  def main(args: Array[String]): Unit = {

    implicit val myname: String = "abi"
    //implicit val myname1 = "abi"
    implicit val secname: Int = 1
    println(sayHello("morning"))

    def sayHello(str: String)(implicit me: String) = {
      s"hello $str. Iam $me"
    }

  }

}
