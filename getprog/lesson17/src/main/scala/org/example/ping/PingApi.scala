// Listing 17.1 The ping API
// file src/main/scala/org/example/ping/PingApi.scala

package org.example.ping

import cats.effect.IO
import org.http4s.dsl.Http4sDsl
import org.http4s.HttpRoutes

class PingApi extends Http4sDsl[IO] {
    
    val routes = HttpRoutes.of[IO] {
        case GET -> Root / "ping" => Ok("pong")
        case GET -> Root / "ping" / name => Ok(s"pong $name")  // QC 17.2
    }
}
