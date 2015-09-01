package gs.psa

import java.net.HttpURLConnection
import java.net.InetSocketAddress
import java.net.Proxy
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

    def receive = {
        case UrlActor.ScrapeUrl(url) =>
            extractNames(url) foreach (println(_))
    }

    private def retrieveUrl(url: String): String = {
        try {
//            val proxy: Proxy =
//                new Proxy(Proxy.Type.HTTP, new InetSocketAddress("{proxy_name}", { proxy_port }))
//            val connection: HttpURLConnection =
//                new URL(url).openConnection(proxy).asInstanceOf[HttpURLConnection]
            val connection: HttpURLConnection =
                new URL(url).openConnection().asInstanceOf[HttpURLConnection]

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

    private def extractNames(source: String): Array[String] = {
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
    case class ScrapeUrl(url: String)
}
