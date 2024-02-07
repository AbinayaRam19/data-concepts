package abiP

object Person {
  println("am in object person")

  def apply(firstName: String, lastName: String): Person = new Person(firstName, lastName)
}

class Person(firstName: String, lastName: String) extends Human1("abi","ram") {
  println("am in class person")

  override def getName: String = firstName + " " + lastName
}

class  Human1(firstName: String, lastName: String){
  println("am in class human")

  def getName: String = firstName + " " + lastName
}

object companionTest {
  def main(args: Array[String]): Unit = {
    val alice1 = Person("Alice", "Christy")
    val alice2 = Person("Alice1", "Christy1")

    println(alice1.getName)
  }
}