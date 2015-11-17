package gs.psa.core

import akka.actor.ActorSystem

/**
 * @author Sebastian Gerau
 */
trait PsaCoreBoot extends PsaCore {

  implicit lazy val system = ActorSystem("Psa")
  sys.addShutdownHook(system.shutdown())

}
