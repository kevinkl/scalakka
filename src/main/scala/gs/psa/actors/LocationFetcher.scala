package gs.psa.actors

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.Props

/**
 * @author Sebastian Gerau
 */
class LocationFetcher extends Actor with ActorLogging {
  import UrlContentFilter._
  import context._

  def receive = {
    case _ => println
  }
}

object LocationFetcher extends Serializable {
  val props = Props[UrlContentFilter]
  case class Locations(locals: Array[String])
}
