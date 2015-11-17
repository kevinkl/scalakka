package gs.psa.core

import akka.actor.Props
import gs.psa.actors.{UrlContentFetcher, UrlContentFilter, UrlRouter}
import gs.psa.actors.LocationFetcher

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