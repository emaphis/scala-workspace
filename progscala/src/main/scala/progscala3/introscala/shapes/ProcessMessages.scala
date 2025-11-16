//src/main/scala/progscala3/introscala/shapes/ProcessMessages.scala
package progscala3.introscala.shapes

object ProcessMessages:

    def apply(message: Message): Message =

        message match
            case Exit =>
                println(s"ProcessingMessage: exiting ...")
                Exit
            case Draw(shape) =>
                shape.draw(str => println(s"ProcessingMessage: $str"))
                Response(s"ProcessingMessage: $shape drawn")
            case Response(unexpected) =>
                val response = Response(s"Error: Unexptected Response: $unexpected")
                println(s"ProccessingMessage: $response")
                response
