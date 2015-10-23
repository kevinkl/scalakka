package gs.psa.actors

import java.net.MalformedURLException
import java.net.URL

import scala.concurrent.duration.Duration
import scala.concurrent.duration.SECONDS

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.actorRef2Scala
import gs.psa.actors.LocationFetcher.Locations
import gs.psa.actors.UrlContentFetcher.ScrapeUrl
import gs.psa.actors.UrlContentFilter.FilterContent

/**
 * @author Sebastian Gerau
 */
class UrlRouter extends Actor with ActorLogging {
  import UrlRouter._
  import context._

  private val system = ActorSystem("UrlContentLocationsFilter")
  private val urlContentFetcher = system.actorOf(UrlContentFetcher.props)
  private val urlContentFilter = system.actorOf(UrlContentFilter.props)
  private val locationFetcher = system.actorOf(LocationFetcher.props)

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
    case params: InitService => {
      init(params.args)
    }
    case scrapeUrl: ScrapeUrl => {
      urlContentFetcher ! scrapeUrl.url
    }
    case filterContent: FilterContent => {
      urlContentFilter ! filterContent.content
    }
    case locations: Locations => {
      locationFetcher ! locations.locals
    }
    case _ => {
      system.shutdown()
      system.awaitTermination(Duration(20, SECONDS))
    }
  }
}

object UrlRouter extends Serializable {
  val props = Props[UrlRouter]
  case class InitService(args: Array[String])
}
