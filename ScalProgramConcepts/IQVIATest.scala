package abiP

trait Human{
  def hello = "Hello from Human"
}

trait Father{
  def hello = "Hello from Father"
}

trait Mother{
  def hello = "Hello from Mother"
}

class Child  extends Human with Father with Mother {

  override def hello: String = ""

  //implement this class to print the below output:
  // Hello from Human
  // Hello from Father
  // Hello from Mother

  def printGreetings()={

    println(super[Human].hello)
    println(super[Father].hello)
    println(super[Mother].hello)

  }

}

object IQVIATest extends App{
  val child = new Child ()
  child.printGreetings()
}
