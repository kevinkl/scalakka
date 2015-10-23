package gs.psa

import java.net.MalformedURLException
import java.net.URL
import scala.concurrent.duration.Duration
import scala.concurrent.duration.SECONDS
import akka.actor.ActorSystem
import akka.actor.actorRef2Scala
import gs.psa.actors.UrlContentFetcher
import gs.psa.actors.UrlContentFetcher.ScrapeUrl
import gs.psa.actors.UrlRouter.InitService
import gs.psa.actors.UrlRouter

/**
 * @author Sebastian Gerau
 */
object Psa {
  def main(args: Array[String]) {
    val system = ActorSystem("Psa")
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
