package abiP
// Service.scala
import com.softwaremill.macwire._




class RealDependency extends Dependency  {
  override def getData(): String = "Real data"
}





class Service(dependency: Dependency) {
  def processData(): String = {
    // Some business logic using the dependency
    s"Processed: ${dependency.getData()}"
  }
}
