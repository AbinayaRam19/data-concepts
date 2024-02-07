package abiP

object partialFun {

  def main(args: Array[String]): Unit = {
    val par = (x: String, y: String) => x + y

    val domain = par("abi", _: String)
    val emailAddress = domain("@gmail.com")

    println("email is: " + emailAddress)


  }

}
