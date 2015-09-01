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

        args.length match {
            case 0 => println("No valid URL specified. You must provide at least one valid URL for processing.")
            case _ => urlActor ! UrlActor.ScrapeUrl(args(0))
        }

        system.shutdown()
        system.awaitTermination(Duration(20, SECONDS))
    }
}
