package gs.psa.actors

import java.net.HttpURLConnection
import java.net.URL

import scala.io.Source

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.Props
import akka.actor.actorRef2Scala

/**
 * @author Sebastian Gerau
 */
class UrlContentFetcher extends Actor with ActorLogging {
  import UrlContentFetcher._
  import context._

  def receive = {
    case url: URL => {
      sender ! extractNames(url)
    }
  }

  private def retrieveUrl(url: URL): String = {
    try {
//      val proxy: Proxy =
//        new Proxy(Proxy.Type.HTTP, new InetSocketAddress("{proxy_name}", { proxy_port }))
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

  private def extractContent(source: String): String = {
    ""
  }

  private def extractNames(source: URL): Array[String] = {
    val cap = """[A-Z]{1}[a-z]+""".r
    retrieveUrl(source).split("""\W""").filter {
      x =>
        x match {
          case cap(_*) => true
          case _ => false
        }
    }.distinct
  }
}

object UrlContentFetcher extends Serializable {
  val props = Props[UrlContentFetcher]
  case class ScrapeUrl(url: URL)
}
