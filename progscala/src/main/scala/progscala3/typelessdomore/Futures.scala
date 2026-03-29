package progscala3.typelessdomore

import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

def sleep(millis: Long): Unit = Thread.sleep(millis)

@main def main2(): Unit = {
  (1 to 5).foreach { i =>
    val future = Future {
      val duration = (math.random * 1000).toLong
      sleep(duration)
      if i == 3 then throw RuntimeException(s"$i -> $duration")
      duration
    }
    future.onComplete {
      case Success(result) => println(s"Success! #$i -> $result")
      case Failure(exception) => println(s"FAILURE! #$i -> $exception")
    }
  }
  sleep(1000) // Wait long enough for the "work" to finish.
  println("Finished!")
}

