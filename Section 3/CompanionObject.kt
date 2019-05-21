@file:Suppress("unused")

package classes

abstract class Vehicle

class VehicleFactory {

    private class RoadVehicle : Vehicle()

    companion object {
        fun newVehicle(): Vehicle {
            return RoadVehicle()
        }

        @JvmStatic
        fun newVehicleStatic(): Vehicle {
            return RoadVehicle()
        }
    }
}