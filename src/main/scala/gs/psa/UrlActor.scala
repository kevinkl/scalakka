package gs.psa

import java.net.HttpURLConnection
import java.net.URL

import scala.io.Source

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.Props

/**
 * @author Sebastian Gerau
 */
class UrlActor extends Actor with ActorLogging {
    import UrlActor._
    import context._

    def receive = {
        case UrlActor.ScrapeUrl(url) => 
            extractNames(url) foreach (println(_))
//            parent ! extractNames(url)
    }

    private def retrieveUrl(url: URL): String = {
        try {
//            val proxy: Proxy =
//                new Proxy(Proxy.Type.HTTP, new InetSocketAddress("{proxy_name}", { proxy_port }))
//            val connection: HttpURLConnection =
//                url.openConnection(proxy).asInstanceOf[HttpURLConnection]
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

object UrlActor extends Serializable {
    val props = Props[UrlActor]
    case class ScrapeUrl(url: URL)
}
