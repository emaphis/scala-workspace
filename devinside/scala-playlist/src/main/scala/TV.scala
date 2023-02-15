
// something like a TV
class TV extends Device {
    override val wattsPerSecond: Int = 500

    protected[this] def actuallyTrunOn() = {
        println("tv on")
    }

    protected[this] def actuallyTrunOff() = {
        println("tv bulb on")
    }
}
