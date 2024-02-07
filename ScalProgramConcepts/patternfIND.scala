package abiP

object patternfIND {


  def main(args: Array[String]): Unit = {

    println("enter the inout string")
    var input: String = scala.io.StdIn.readLine()
    println("pattern count: " + findPatter(input))

    def findPatter(input: String): Int = {
      if (input.length < 3) -1
      else {
        var patCounter = 0
        if (!input.contains('1')) patCounter = 0
        var i = 0
        var flag = 0
        while (i < input.length - 1) {

          if (input(i).equals('1') && input(i + 1).equals('0')) {
            println("first cond true")
            flag = i + 1
            while (input(flag + 1).equals('0') && !input(flag + 1).equals('1')) {
              println("sec cond true")
              flag += 1
            }
            println("lopp :" + flag)
            println("input(flag+1).equals('1')" + input(flag + 1).equals('1'))
            if (input(flag + 1).equals('1')) {
              println("pat counter: " + patCounter)
              patCounter += 1
            }

          }
          i = i + 1
        }
        patCounter
      }
    }
  }
}
