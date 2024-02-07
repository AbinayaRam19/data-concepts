package abiP

trait AIqvia {
  def greet(): String = "Hello from A"
}

trait BIqvia {
  def greet(): String = "Hello from B"
}

class MyClassIqvia extends AIqvia with BIqvia {
  override def greet(): String = super[AIqvia].greet()
  def printGreetings(): Unit = {
    // Implement the class to print the below
    //Hello from B
    //Hello from A
    println(greet())
  }
}

object IQVIATest1 extends App {
  val myObject = new MyClassIqvia
  myObject.printGreetings()
}