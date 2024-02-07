package abiP

import com.softwaremill.macwire._

class Heater extends Switchable {
  override def turnOn(): Unit = println("Heater turned on")
  override def turnOff(): Unit = println("Heater turned off")
}
