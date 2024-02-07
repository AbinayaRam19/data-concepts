package abiP

/*
Goals: Design a parking lot using object-oriented principles
Here are a few methods that you should be able to run:

Tell us how many spots are remaining
Tell us how many total spots are in the parking lot
Tell us when the parking lot is full
Tell us when the parking lot is empty
Tell us when certain spots are full e.g. when all motorcycle spots are taken
Tell us how many spots vans are taking up
Assumptions:

The parking lot can hold motorcycles, cars and vans
The parking lot has motorcycle spots, car spots and large spots
A motorcycle can park in any spot
A car can park in a single compact spot, or a regular spot
A van can park, but it will take up 3 regular spots
 */

object ParkingLotApp extends App {
  private val parkingLot = new ParkingLot(30)

  parkingLot.parkVehicle(Motorcycle)
  parkingLot.parkVehicle(Car)
  parkingLot.parkVehicle(Van)

  println(s"Remaining spots: ${parkingLot.remainingSpots}")
  println(s"Total spots: ${parkingLot.totalSpots}")
  println(s"Parking lot is full: ${parkingLot.isFull}")
  println(s"Parking lot is empty: ${parkingLot.isEmpty}")
  println(s"Motorcycle spots full: ${parkingLot.isSpotFull(Motorcycle)}")
  println(s"Vans taking up spots: ${parkingLot.vansTakingSpots}")

  private class ParkingLot(val totalSpots: Int) {
    private var availableSpots = totalSpots
    private var motorcycleSpots = totalSpots / 2
    private var carSpots = totalSpots / 2
    private var vanSpots = totalSpots / 3

    def parkVehicle(vehicleType: VehicleType): Unit = {
      if (availableSpots > 0) {
        vehicleType match {
          case Motorcycle => motorcycleSpots -= 1
          case Car => carSpots -= 1
          case Van => vanSpots -= 3
        }
        availableSpots -= 1
        println(s"Parked a $vehicleType")
      } else {
        println("Parking lot is full. Cannot park.")
      }
    }

    def remainingSpots: Int = availableSpots
    def isFull: Boolean = availableSpots == 0
    def isEmpty: Boolean = availableSpots == totalSpots
    def isSpotFull(vehicleType: VehicleType): Boolean = {
      vehicleType match {
        case Motorcycle => motorcycleSpots == 0
        case Car => carSpots == 0
        case Van => vanSpots == 0
      }
    }
    def vansTakingSpots: Int = (totalSpots - availableSpots - motorcycleSpots - carSpots) / 3
  }

  sealed trait VehicleType
  case object Motorcycle extends VehicleType
  case object Car extends VehicleType
  case object Van extends VehicleType
}
