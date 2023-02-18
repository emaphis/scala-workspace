// Video 17 - Traits.

object  Core {

    abstract class OrdinaryCar(override val model: String)
     extends Base.Car {
        def topSpeedInKmPerHour: Int = 220
        def topAccelerationInRpm: Int = 8000
    }

    abstract class SportsCar(override val model: String)
     extends Base.Car {
        def topSpeedInKmPerHour: Int = 300
        def topAccelerationInRpm: Int = 11000
    }

}
