// Chapter 16
// Mutable Objects

// 16.3 Case study: Discrete event simulation
// 16.4 A language for digital circuits
// 16.6 Circuit Simulation

package chap16.simulation

// Listing 16.9 · The BasicCircuitSimulation class

abstract class BasicCircuitSimulation
  extends Simulation:

  def InverterDelay: Int
  def AndGateDelay: Int
  def OrGateDelay: Int

  class Wire:

    private var sigVal = false
    private var actions: List[Action] = List.empty

    def getSignal: Boolean = sigVal

    def setSignal(sig: Boolean): Unit =
      if sig != sigVal then
        sigVal = sig
        actions.foreach(_())

    def addAction(act: Action): Unit =
      actions = act :: actions
      act()

  def inverter(input: Wire, output: Wire): Unit =
    def invertAction(): Unit =
      val inputSig = input.getSignal
      afterDelay(InverterDelay) {
        output setSignal !inputSig
      }
      input.addAction(invertAction)

  def andGate(a1: Wire, a2: Wire, output: Wire): Unit =
    def andAction(): Unit =
      val a1Sig = a1.getSignal
      val a2Sig = a2.getSignal
      afterDelay(AndGateDelay) {
        output.setSignal(a1Sig & a2Sig)
      }
      a1 addAction andAction
      a2 addAction andAction

  def orGate(o1: Wire, o2: Wire, output: Wire): Unit =
    def orAction(): Unit =
      val o1Sig = o1.getSignal
      val o2Sig = o2.getSignal
      afterDelay(OrGateDelay) {
        output.setSignal(o1Sig | o2Sig)
      }
      o1.addAction(orAction)
      o2.addAction(orAction)

  def probe(name: String, wire: Wire): Unit =
    def probeAction(): Unit =
      println(name + " " +  currentTime + " new-value = " + wire.getSignal)
    println("Probe: -- ")
    wire.addAction(probeAction)
