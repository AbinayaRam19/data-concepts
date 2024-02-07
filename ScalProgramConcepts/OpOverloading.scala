package abiP

class Complex(val real: Double, val imag: Double) {

  def +(that: Complex) = {
    new Complex(this.real + that.real, this.imag + that.imag)
  }

  def -(that: Complex) =
    new Complex(this.real - that.real, this.imag - that.imag)

  override def toString: String = real + " + " + imag + "i"

}

object OpOverloading {
  def main(args: Array[String]): Unit = {
    var a = new Complex(4.0, 5.0)
    var b = new Complex(2.0, 3.0)
    println(a) // 4.0 + 5.0i
    println(a + b) // 6.0 + 8.0i
    println(a - b) // 2.0 + 2.0i
  }
}