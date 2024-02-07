package abiP

class Line {
  val radius = 6;
  println("Line")
  //  def calcArea:Unit={
  //    println("-----1> "+radius)
  //  }
}


class Square extends Line {
  override val radius = 6;

  println("Square")
  //  override def calcArea:Unit={
  //    println("-----2> "+radius)
  //  }
}

class Circle extends Line {
  override val radius = 5;
  println("Circle")
  //  override def calcArea = {
  //    println(radius * radius )
  //  }
}

//class Sphere extends Circle{
//   override def calcArea = {
//    println(radius * radius * radius )
//  }
//}
object Inheritance {
  def main(args: Array[String]) {
    //new Square().calcArea


    new Square()
  }
}