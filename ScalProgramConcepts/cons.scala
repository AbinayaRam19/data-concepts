package abiP

object cons extends App {

  //  class Vehicle{
  //    println("am a primary constructor")
  //  }
  class Vehicle(model: String, color: String) {
    var year: Int = 2000

    def show(): Unit = {
      println("I am a " + color + " " + model + " from " + year)
    }

    def this(model: String, color: String, year: Int) {
      this(model, color) //Call to the primary constructor
      this.year = year
    }
  }

  def functionName(x:Int,y:Int)=x+y

  val welcomeStrings = new Array[String](3)
  welcomeStrings(0) = "Welcome"
  welcomeStrings(1) = "to "
  welcomeStrings(2) = "ProjectPro"
  welcomeStrings(0) = "Welcome bb"


  println(welcomeStrings(0))


  var v = new Vehicle("Verna", "red", 2015)
  v.show()
  var v1 = new Vehicle("Verna", "black")
  v1.show()

}
