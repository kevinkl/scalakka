package gs.psa.core

import akka.actor.ActorSystem

/**
 * @author Sebastian Gerau
 */
trait PsaCoreBoot extends PsaCore {

  implicit lazy val psaSystem = ActorSystem("Psa")
  sys.addShutdownHook(psaSystem.shutdown())

}
