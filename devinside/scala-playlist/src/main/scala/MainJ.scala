// Video # 15
object MainJ {

  /** An Example */
  def core(args: Array[String]) = {

    trait Device {
      val wattsPerSecond: Int
      def turnOn(): Unit
      def turnOff(): Unit
    }

    // something like a TV
    class TV extends Device {
      override val wattsPerSecond: Int = 500

      override def turnOn(): Unit = {
        println("TV on")
      }

      override def turnOff(): Unit = {
        println("TV off")
      }
    }

    // something like a Light Bulb
    class LightBulb extends Device {

      override val wattsPerSecond: Int = 100

      override def turnOn(): Unit = {
        println("Light Buld on")
      }

      override def turnOff(): Unit = {
        println("Light Bulb off")
      }
    }

    class EnergyMeter(device: Device) {
      private[this] var turnedOnAtMillis: Long = 0
      private[this] var _wattsConsumedInTotal: Double = 0
      def wattsConsumedInTotal: Double = _wattsConsumedInTotal
      private[this] def wattsConsumedInTotal_=(newValue: Double): Unit ={
         _wattsConsumedInTotal = newValue
      }

      def startMeeasuring(): Unit = {
        device.turnOn()

        turnedOnAtMillis = System.currentTimeMillis
      }

      def stopMeeasuring(): Unit = {
        device.turnOff()

        val durationInMillis = System.currentTimeMillis - turnedOnAtMillis
        val durationInSecons = durationInMillis.toDouble / 1000

        wattsConsumedInTotal += device.wattsPerSecond * durationInSecons
      }
    }

    object EnergyMeter {

    }

    val lightBulb: LightBulb = new LightBulb
    val tv: TV = new TV

    val energyMeter = new EnergyMeter(tv)

    energyMeter.startMeeasuring()
    Thread.sleep(1000)
    energyMeter.stopMeeasuring()
    println(energyMeter.wattsConsumedInTotal)

    println()
    energyMeter.startMeeasuring()
    Thread.sleep(1000)
    energyMeter.stopMeeasuring()
    println(energyMeter.wattsConsumedInTotal)

    println("\nHello video 15")
  }

  /** main program */
  def main2(args: Array[String]): Unit = {
    println("-" * 50)
    core(args)
    println("-" * 50)
  }
}
