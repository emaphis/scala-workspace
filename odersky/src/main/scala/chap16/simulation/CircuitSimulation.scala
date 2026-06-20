// Chapter 16
// Mutable Objects

// 16.3 Case study: Discrete event simulation
// 16.4 A language for digital circuits
package chap16.simulation

//Listing 16.11 · The CircuitSimulation class

abstract class CircuitSimulation
  extends BasicCircuitSimulation:

  // Listing 16.6 · The halfAdder method.
  def halfAdder(a: Wire, b: Wire, s: Wire, c: Wire): Unit =
    val d, e = new Wire
    orGate(a, b, d)
    andGate(a, b, c)
    inverter(c, e)
    andGate(d, e, s)

  // Listing 16.7 · The fullAdder method.
  def fullAdder(a: Wire, b: Wire, cin: Wire, sum: Wire, cout: Wire): Unit =
    val s, c1, c2 = new Wire
    halfAdder(a, cin, s, c1)
    halfAdder(b, s, sum, c2)
    orGate(c1, c2, cout)
