// Video 16 - Inheritance
// Other files in Device.scala, LightBubl.scala and TV.scala

object MainK {

  /** An Example */
  def code(args: Array[String]) = {
    val bulb = new LightBulb
    val tv = new TV
    val meter = new EnergyMeter(bulb)

    meter.startMeasuring()
    Thread.sleep(1000)
    meter.stopMeasuring()
    println(meter.wattsConsumedInTotal)

    println()

    meter.startMeasuring()
    Thread.sleep(1000)
    meter.stopMeasuring()
    println(meter.wattsConsumedInTotal)
  }

  /** main program */
  def mainK(args: Array[String]): Unit = {
    println("-" * 50)
    code(args)
    println("-" * 50)
  }
}
