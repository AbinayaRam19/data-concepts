package abiP

trait A2 {
  def show(): Unit = println("A2")
}

trait B2 extends A2 {
  override def show(): Unit = {
    super.show()
    println("B2")
  }
}

trait C2 extends A2 {
  override def show(): Unit = {
    super.show()
    println("C2")
  }
}

class D2 extends B2 with C2 {
  def display(): Unit = {
    show()
  }
}

object Main2 {
  def main(args: Array[String]): Unit = {
    val obj = new D2
    obj.display()
  }
}