package service.b.core

import service.a.core.ACore
import akka.actor.ActorSystem

/**
 * @author Sebastian Gerau
 */
trait BCoreBooted extends ACore {
  
  implicit lazy val system = ActorSystem()
  sys.addShutdownHook(system.terminate())
  
}
