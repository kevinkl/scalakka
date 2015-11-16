package gs.psa.core

import akka.actor.{Props, ActorSystem}
import gs.psa.actors.UrlRouter

/**
 * @author Sebastian Gerau
 */
trait PsaCoreActors {
  psaCore: PsaCore =>

  val urlRouter = psaSystem.actorOf(Props[UrlRouter])

}