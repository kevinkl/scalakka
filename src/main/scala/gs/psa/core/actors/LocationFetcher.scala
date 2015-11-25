package gs.psa.core.actors

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.actorRef2Scala

/**
 * @author Sebastian Gerau
 */
class LocationFetcher extends Actor with ActorLogging {
  import LocationFetcher._
  
  def receive = {
    case locations: Locations => {
      locations.locals foreach println
      sender ! "shutdown"
    }
  }
}

object LocationFetcher extends Serializable {
  case class Locations(locals: Array[String])
}
