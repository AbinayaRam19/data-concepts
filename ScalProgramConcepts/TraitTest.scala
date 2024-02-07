package abiP

// Abstract class with constructor parameters
abstract class Shape(val name: String, val color: String) {
  def area(): Double    // Abstract method

  // Concrete method using constructor parameters
  def displayInfo(): Unit = {
    println(s"$name (Color: $color)")
    println(s"Area: ${area()}")
  }
}

// Trait with a method
trait sparkalable {
  def sparkale(factor: Double): Unit = {
    println(s"sparkaling by factor: $factor")
  }
}

// Concrete class extending the abstract class and mixing in the trait
class Circle2(radius: Double, color: String) extends Shape("Circle", color) with sparkalable {
  def area(): Double = math.Pi * radius * radius

  override def displayInfo(): Unit = {
    println(s"$name (Color: $color)")
  }
}

object AbstractClassTraitExample extends App {
  val coloredCircle = new Circle2(radius = 3.0, color = "Blue")

  // Call methods from abstract class
  coloredCircle.displayInfo()

  // Call method from the trait
  coloredCircle.sparkale(factor = 2.0)
}