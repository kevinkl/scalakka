package service.a.app

import scala.concurrent.ExecutionContext
import scala.io.StdIn

import akka.http.scaladsl.Http
import akka.http.scaladsl.marshallers.xml.ScalaXmlSupport.defaultNodeSeqMarshaller
import akka.http.scaladsl.marshalling.ToResponseMarshallable.apply
import akka.http.scaladsl.server.Directive.addByNameNullaryApply
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.RouteResult.route2HandlerFlow
import akka.stream.ActorMaterializer
import service.a.core.ACoreBooted

/**
 * @author Sebastian Gerau
 */
object AService extends App with ACoreBooted with AConfig {
  
  protected implicit val executor: ExecutionContext = system.dispatcher
  protected implicit val materializer: ActorMaterializer = ActorMaterializer()

  val route = 
    path("hello") {
      get {
        complete {
          <h1>Say hello to akka-http</h1>
        }
      }
    } ~
    path("dude") {
      get {
        complete {
          <h1>Say hello to dude</h1>
        }
      }
    }
  
  val bindingFuture = Http().bindAndHandle(route, "localhost", port.toInt)
  
  println(s"Server online at http://localhost:11011/\nPress RETURN to stop...")
  StdIn.readLine()
  bindingFuture
    .flatMap(_.unbind())
    .onComplete { _ => system.terminate() }

}