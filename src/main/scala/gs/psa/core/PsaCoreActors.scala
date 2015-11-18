package gs.psa.core

import akka.actor.Props
import gs.psa.core.actors.{UrlContentFetcher, UrlContentFilter, UrlRouter}
import gs.psa.core.actors.LocationFetcher

/**
 * @author Sebastian Gerau
 */
trait PsaCoreActors {
  psaCore: PsaCore =>

  val urlRouter = system.actorOf(Props[UrlRouter])
  val urlContentFetcher = system.actorOf(Props[UrlContentFetcher])
  val urlContentFilter = system.actorOf(Props[UrlContentFilter])
  val locationFetcher = system.actorOf(Props[LocationFetcher])

}