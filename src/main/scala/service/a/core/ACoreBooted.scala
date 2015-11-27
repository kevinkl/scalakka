package service.a.core

import akka.actor.ActorSystem

/**
 * @author Sebastian Gerau
 */
trait ACoreBooted extends ACore {
  
  implicit lazy val system = ActorSystem()
  sys.addShutdownHook(system.terminate())
  
}
