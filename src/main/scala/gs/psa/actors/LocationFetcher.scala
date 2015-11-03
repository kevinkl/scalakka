package gs.psa.actors

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.Props
import akka.actor.actorRef2Scala

/**
 * @author Sebastian Gerau
 */
class LocationFetcher extends Actor with ActorLogging {
  import LocationFetcher._
  import context._

  def receive = {
    case locations: Array[String] => {
      locations foreach println
      sender ! "shutdown"
    }
  }
}

object LocationFetcher extends Serializable {
  val props = Props[LocationFetcher]
  case class Locations(locals: Array[String])
}
