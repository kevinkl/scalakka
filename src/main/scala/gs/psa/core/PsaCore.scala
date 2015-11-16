package gs.psa.core

import akka.actor.ActorSystem

/**
 * @author Sebastian Gerau
 */
trait PsaCore {

  implicit def psaSystem: ActorSystem

}
