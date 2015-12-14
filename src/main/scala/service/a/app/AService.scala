package service.a.app

import service.a.core.ACoreBooted
import scala.concurrent.ExecutionContext
import akka.stream.ActorMaterializer

/**
 * @author Sebastian Gerau
 */
object AService extends App with ACoreBooted with AConfig {
  
  protected implicit val executor: ExecutionContext = system.dispatcher
  protected implicit val materializer: ActorMaterializer = ActorMaterializer()
  
}