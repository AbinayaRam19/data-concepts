package abiP

object foldScala {
  // Main method
  def main(arg: Array[String]) {
    // initialize a sequence of strings
    val str_elements: Seq[String] = Seq("hello",
      "Geeks", "For", "Geeks")
    println(s"Elements = $str_elements")

    // Concatenate strings with fold function
    val concat: String = str_elements.foldRight("@")(
      (a, b) => a + "-" + b)
    println(s"After concatenation = $concat") // hello-Geeks-For-Geeks-@
  }
}
