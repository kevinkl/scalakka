package gs.psa

import java.net.MalformedURLException
import java.net.URL

import scala.concurrent.duration.Duration
import scala.concurrent.duration.SECONDS

import akka.actor.ActorSystem
import akka.actor.actorRef2Scala
import gs.psa.actors.UrlContentFetcher

/**
 * @author Sebastian Gerau
 */
object Psa {
  def main(args: Array[String]) {
    val system = ActorSystem("Psa")
    val fetcher = system.actorOf(UrlContentFetcher.props)

    args.length match {
      case 0 => println("No valid URL specified. You must provide at least one valid URL for processing.")
      case _ => {
        try {
          val url: URL = new URL(args(0))
          fetcher ! UrlContentFetcher.ScrapeUrl(url)
        } catch {
          case e: MalformedURLException => e.getStackTrace().mkString
        }
      }
    }

    system.shutdown()
    system.awaitTermination(Duration(20, SECONDS))
  }
}
