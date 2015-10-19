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
class UrlContentFilter extends Actor with ActorLogging {
  import UrlContentFilter._
  import context._

  def receive = {
    case content: String => {
      sender ! extractNames(content)
    }
  }

  private def extractNames(content: String): Array[String] = {
    val cap = """[A-Z]{1}[a-z]+""".r
    content.split("""\W""").filter {
      x =>
        x match {
          case cap(_*) => true
          case _ => false
        }
    }.distinct
  }
}

object UrlContentFilter extends Serializable {
  val props = Props[UrlContentFilter]
  case class FilterUrl(content: String)
}