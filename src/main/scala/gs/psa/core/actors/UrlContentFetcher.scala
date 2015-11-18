package gs.psa.core.actors

import java.net.HttpURLConnection
import java.net.InetSocketAddress
import java.net.Proxy
import java.net.URL

import scala.io.Source

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.actorRef2Scala
import gs.psa.core.actors.UrlContentFilter.FilterContent
import gs.psa.core.actors.UrlContentFetcher.ScrapeUrl

/**
 * @author Sebastian Gerau
 */
class UrlContentFetcher extends Actor with ActorLogging {

  def receive = {
    case scrapeUrl: ScrapeUrl => {
      sender ! FilterContent(retrieveUrl(scrapeUrl.url))
    }
  }

  private def retrieveUrl(url: URL): String = {
    try {
//      val proxy: Proxy =
//        new Proxy(Proxy.Type.HTTP, new InetSocketAddress("{proxy_name}", { proxy_port }))
//        new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy", 1234))
//      val connection: HttpURLConnection =
//        url.openConnection(proxy).asInstanceOf[HttpURLConnection]
      val connection: HttpURLConnection =
        url.openConnection().asInstanceOf[HttpURLConnection]

      connection.connect()
      log.info("Retrieving content of " + url)
      Source.fromInputStream(connection.getInputStream).getLines.mkString
    } catch {
      case e: Throwable => e.getStackTrace.mkString
    }
  }
}

object UrlContentFetcher extends Serializable {
  case class ScrapeUrl(url: URL)
}
