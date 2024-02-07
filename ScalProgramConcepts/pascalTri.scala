package abiP

object pasparkalTri { //Pasparkal function
  def printPasparkal(n: Int): Unit = {
    for (line <- 1 to n) {
      var C = 1 // used to represent C(line, i)
      for (i <- 1 to line) { // The first value in a line is always 1
        print(C + " ")

        println("LINE: " + (line - i) + " i : " + i)
        println("C:  " + C * (line - i) / i)
        C = C * (line - i) / i
        //print("C value: "+C)
      }
      System.out.println()
    }
  }

  // Driver code
  def main(args: Array[String]): Unit = {
    val n = 3
    printPasparkal(n)
  }
}
