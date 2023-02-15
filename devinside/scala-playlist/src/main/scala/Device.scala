// Video 16 - Inheritance

trait Device {
    val wattsPerSecond: Int

    private[this] var _isOn: Boolean = false

    def isOn: Boolean = _isOn   // setter
    protected [this] def isOn_=(newValue: Boolean): Unit = {
        _isOn = newValue
    }

    def isOff: Boolean = !isOn
    protected [this] def isOff_=(newValue: Boolean): Unit = {
        _isOn = !newValue
    }

    final def turnOn(): Unit = {
        if(isOff) {
            isOn = true
            actuallyTrunOn()
        }
        else
            sys.error("already on")
    }

    protected[this] def actuallyTrunOn()

    final def turnOff(): Unit = {
        if(isOn) {
            isOff = true
            actuallyTrunOff()
        }
        else
            sys.error("already off")
    }

    protected[this] def actuallyTrunOff()
}

