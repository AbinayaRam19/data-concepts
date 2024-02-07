package abiP

object defaultTest {

  def main(args: Array[String]): Unit = {
    test(15, 5)

  }

  def test(x: Int = 10, y: Int): Unit = {
    println(x + y);
  }

}
