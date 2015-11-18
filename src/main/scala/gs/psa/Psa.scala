package gs.psa

import java.net.MalformedURLException
import akka.actor.actorRef2Scala
import gs.psa.core.{PsaCoreActors, PsaCoreBoot}
import gs.psa.core.actors.UrlRouter.InitService

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
