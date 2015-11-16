package gs.psa

import java.net.MalformedURLException
import akka.actor.ActorSystem
import akka.actor.actorRef2Scala
import gs.psa.actors.UrlRouter
import gs.psa.actors.UrlRouter.InitService
import gs.psa.core.PsaCoreBoot
import gs.psa.core.PsaCoreActors

/**
 * @author Sebastian Gerau
 */
object Psa extends App with PsaCoreBoot with PsaCoreActors {

  args.length match {
    case _ => {
      try {
        urlRouter ! InitService(args)
      } catch {
        case e: MalformedURLException => e.getStackTrace().mkString
      }
    }
  }

}
