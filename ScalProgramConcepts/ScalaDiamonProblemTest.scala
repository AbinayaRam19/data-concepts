package abiP

trait A1 {
  def display() {
    println("From A.display")
  }
}

trait B1 extends A1 {
  override def display() {
    println("From B.display")
  }
}

trait C1 extends A1 {
  override def display() {
    println("From C.display")
  }
}

class D1 extends C1 with B1 {}

object sparkalaDiamonProblemTest extends App {

  val d = new D1
  d display

}

