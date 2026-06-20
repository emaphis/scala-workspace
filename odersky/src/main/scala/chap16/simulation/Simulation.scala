// Chapter 16
// Mutable Objects

// 16.3 Case study: Discrete event simulation
// 16.4 A language for digital circuits
// 16.5 The Simulation API

package chap16.simulation

// Listing 16.8 · The Simulation class.
abstract class Simulation:

  type Action = () => Unit

  case class WorkItem(time: Int, action: Action)

  private var curtime = 0
  def currentTime: Int = curtime

  private var agenda: List[WorkItem] = List()

  private def insert(ag: List[WorkItem], item: WorkItem): List[WorkItem] =
    if ag.isEmpty || item.time < ag.head.time then item :: ag
    else ag.head :: insert(ag.tail, item)

  def afterDelay(delay: Int)(block: => Unit): Unit =
    val item = WorkItem(currentTime + delay, () => block)
    agenda = insert(agenda, item)

  private def next(): Unit =
    (agenda: @unchecked) match
      case item :: rest =>
        agenda = rest
        curtime = item.time
        item.action()

  def run(): Unit =
    afterDelay(0) {
      println("*** simulation started, time = " + currentTime + " ***")
    }
    while !agenda.isEmpty do next()
