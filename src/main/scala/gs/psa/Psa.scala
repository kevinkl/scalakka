package gs.psa

import akka.actor.ActorSystem
import scala.concurrent.duration._

/**
 * @author Sebastian Gerau
 */
object Psa {
  def main(args: Array[String]) {
    val system = ActorSystem("Psa")
    val urlActor = system.actorOf(UrlActor.props, "urlActor")
    urlActor ! UrlActor.ScrapeUrl(args(0))
    system.shutdown()
    system.awaitTermination(Duration(20, SECONDS))
  }
}
