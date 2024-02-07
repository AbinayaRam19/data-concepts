package abiP

object Capitalise {


  def main(args: Array[String]): Unit = {

    println("enter the line")
    var input = scala.io.StdIn.readLine()

    val length = input.length
    println("lebtght of string: " + length)


    // var arr = input.split(" ")

    var newstr = ""

    newstr += Character.toUpperCase(input.charAt(0))
    var i = 1
    while (i < input.length - 1) {
      if ((input.charAt(i + 1).equals(' ')) ||
        (input.charAt(i - 1).equals(' ')))
        newstr += Character.toUpperCase(input.charAt(i))
      else newstr += input.charAt(i)

      i += 1
    }
    newstr += Character.toUpperCase(input.charAt(input.length - 1))

    println("final string : " + newstr)
  }
}
