// Chapter 16
// Mutable Objects

package chap16
import chap16.simulation.CircuitSimulation

object MySimulation extends CircuitSimulation:
  def InverterDelay = 1
  def AndGateDelay = 3
  def OrGateDelay = 5

object Test {

  def main(args: Array[String]): Unit = {
    import MySimulation.*

    val input1, input2, sum, carry = new Wire

    probe("sum", sum)
    probe("carry", carry)
    halfAdder(input1, input2, sum, carry)

    input1.setSignal(true)
    run()

    input2.setSignal(true)
    run()
  }
}
