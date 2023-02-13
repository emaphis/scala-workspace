import scala.concurrent.duration.FiniteDuration
import java.util.Timer
import java.util.TimerTask


object Scala {
    def tickUntilEnterIsPressed(interval: FiniteDuration)(someCode: => Unit) = {
        val timer: Timer = new Timer
        
        val delayInMilliseconds: Long = 0
        val periodInMillisecond: Long = interval.toMillis

        val timerTask2: TimerTask = new TimerTask {
            def run(): Unit = {
                someCode
            }
        }

        val timerTask: TimerTask = ( ) => someCode 
    
        timer.scheduleAtFixedRate(
            timerTask,
            delayInMilliseconds,
            periodInMillisecond
        )

        io.StdIn.readLine   // blacok current thread until Enter is pressed
        timer.cancel()
    }

    def loop(times: Int)(someCode: => Unit) = {
        1 to times foreach {_ => 
            someCode
        }
    }

    def wait(delay: FiniteDuration): Unit = {
        Thread.sleep(delay.toMillis)
    }
}