package abiP

import com.softwaremill.macwire._

object SwitchApp extends App {
  // Using MacWire to wire dependencies
  val switchForHeater = wire[Heater]

  // Operate the heater switch
  switchForHeater.turnOn()
}