package gs.psa

import java.net.MalformedURLException

import akka.actor.ActorSystem
import akka.actor.actorRef2Scala
import gs.psa.actors.UrlRouter
import gs.psa.actors.UrlRouter.InitService

/**
 * @author Sebastian Gerau
 */
object Psa {
  def main(args: Array[String]) {
    val system = ActorSystem("psa")
    val router = system.actorOf(UrlRouter.props)

    args.length match {
      case _ => {
        try {
          router ! InitService(args)
        } catch {
          case e: MalformedURLException => e.getStackTrace().mkString
        }
      }
    }
  }
}
