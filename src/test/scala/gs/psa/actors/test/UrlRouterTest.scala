package gs.psa.actors.test

import java.net.MalformedURLException
import java.net.URL

import org.scalatest.SpecLike

import akka.actor.ActorSystem
import akka.actor.actorRef2Scala
import akka.testkit.ImplicitSender
import akka.testkit.TestKit
import gs.psa.actors.UrlRouter

/**
 * @author Sebastian Gerau
 */
class UrlRouterTest(_system: ActorSystem) extends TestKit(_system) with ImplicitSender
    with SpecLike {

  def this() = this(ActorSystem("UrlRouterTest"))

  object `A UrlRouterTest` {
    object `when processing an invalid URL` {
      def `should produce a MalformedURLException when invoked` {
        val testRouter = system.actorOf(UrlRouter.props, "testRouter0")

        intercept[MalformedURLException] {
          testRouter ! new URL("dud!")
        }
      }
    }
  }
}
