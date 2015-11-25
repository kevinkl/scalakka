package gs.psa.core.actors

import java.net.MalformedURLException
import java.net.URL

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.actorRef2Scala
import gs.psa.core.PsaCoreActors
import gs.psa.core.PsaCoreBoot

/**
 * @author Sebastian Gerau
 */
class UrlRouter extends Actor with ActorLogging with PsaCoreBoot with PsaCoreActors {
  import UrlRouter._
  import UrlContentFetcher._
  import UrlContentFilter._
  import LocationFetcher._
  
  def init(args: Array[String]) {
    args(0).length match {
      case 0 => {
        println("No valid URL specified. You must provide at least one valid URL for processing.")
      }
      case _ => {
        try {
          val urlArgs = new URL(args(0))
          val url: ScrapeUrl = new ScrapeUrl(urlArgs)

          self ! url
        } catch {
          case e: MalformedURLException => e.getStackTrace().mkString
        }
      }
    }
  }
  
  def receive = {
    case params: InitService => init(params.args)
    case scrapeUrl: ScrapeUrl => urlContentFetcher ! scrapeUrl
    case filterContent: FilterContent => urlContentFilter ! filterContent
    case locations: Locations => locationFetcher ! locations
    case "shutdown" => sys.exit()
  }
}

object UrlRouter extends Serializable {
  case class InitService(args: Array[String])
}
