// something like a Light Bulb
class LightBulb extends Device {
    override val wattsPerSecond: Int = 100

    protected[this] def actuallyTrunOn() = {
        println("light bulb on")
    }

    protected[this] def actuallyTrunOff() = {
        println("light bulb off")
    }

}
