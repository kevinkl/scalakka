package gs.psa.core.actors

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.actorRef2Scala
import gs.psa.core.actors.LocationFetcher.Locations

/**
 * @author Sebastian Gerau
 */
class LocationFetcher extends Actor with ActorLogging {

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
