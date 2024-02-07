package abiP

object StringRev {


  def main(args: Array[String]): Unit = {


    var string = "Abinaya"
    var newstr = ""
    for (i <- string.length - 1 to 0 by -1) {
      newstr += string(i)
    }

    println("reversed string is: " + newstr)
  }

}
