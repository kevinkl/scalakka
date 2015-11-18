package gs.psa.core.actors

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.actorRef2Scala
import gs.psa.core.actors.LocationFetcher.Locations
import gs.psa.core.actors.UrlContentFilter.FilterContent

/**
 * @author Sebastian Gerau
 */
class UrlContentFilter extends Actor with ActorLogging {

  def receive = {
    case filterUrl: FilterContent => {
      sender ! Locations(extractNames(filterUrl.content))
    }
  }

  private def extractNames(content: String): Array[String] = {
    val cap = """[A-Z]{1}[a-z]+""".r
    content.split("""\W""").filter {
      x =>
        x match {
          case cap(_*) => true
          case _ => false
        }
    }.distinct
  }
}

object UrlContentFilter extends Serializable {
  case class FilterContent(content: String)
}
