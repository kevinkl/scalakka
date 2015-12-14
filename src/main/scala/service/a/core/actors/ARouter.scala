package service.a.core.actors

import akka.actor.Actor
import akka.actor.ActorLogging

class ARouter extends Actor with ActorLogging {
  import ARouter._
  
  def receive = {
    case _ => sender ! "Not yet implemented"
  }

}

object ARouter extends Serializable {
  
}