package service.a.core

import akka.actor.ActorSystem

/**
 * @author Sebastian Gerau
 */
trait ACore {
  
  implicit def system: ActorSystem
  
}
