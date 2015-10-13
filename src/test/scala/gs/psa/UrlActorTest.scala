package gs.psa

import java.net.MalformedURLException
import java.net.URL

import org.scalatest.Spec

import akka.actor.ActorSystem
import akka.actor.actorRef2Scala

/**
 * @author Sebastian Gerau
 */
class UrlActorTest extends Spec {
    object `A UrlActor` {
        object `when processing an invalid URL` {
            def `should produce a MalformedURLException when invoked` {
                val testSystem = ActorSystem("TestPsa")
                val testUrlActor = testSystem.actorOf(UrlActor.props, "testUrlActor")
                intercept[MalformedURLException] {
                    testUrlActor ! UrlActor.ScrapeUrl(new URL("dud!"))
                }
            }
        }
    }
}
