// Video 71 - Traits

object Base {
    abstract class Car {
        def model: String
        def topSpeedInKmPerHour: Int
        def topAccelerationInRpm: Int
        def brand: String

        override def toString(): String = {
            brand + " " + model + " " + topSpeedInKmPerHour + " " + topAccelerationInRpm
        }
    }
}