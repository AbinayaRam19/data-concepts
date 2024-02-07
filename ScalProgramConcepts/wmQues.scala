package abiP

object wmQues {

  def main(args: Array[String]): Unit = {

    var arrayA = Array("bat", "", "", "", "", "cat", "", "", "dog")

    arrayA.foreach(a => {
      if (a.isEmpty) println(1)
      else println(a)
    })
  }
}
