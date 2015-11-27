package service.b.core

import akka.actor.ActorSystem

/**
 * @author Sebastian Gerau
 */
trait BCore {
  
  implicit def system: ActorSystem
  
}
