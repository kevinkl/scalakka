package gs.psa.core.actors

import java.net.MalformedURLException
import java.net.URL

import org.scalatest.SpecLike

import akka.actor.ActorSystem
import akka.actor.actorRef2Scala
import akka.testkit.ImplicitSender
import akka.testkit.TestKit
import gs.psa.core.PsaCore
import gs.psa.core.PsaCoreActors

/**
 * @author Sebastian Gerau
 */
class UrlRouterTest extends TestKit(ActorSystem()) with SpecLike with PsaCoreActors 
with PsaCore with ImplicitSender {
  import UrlRouter._
  
  object `A UrlRouter` {
    object `when processing an invalid URL` {
      def `should produce a MalformedURLException when invoked` {
        intercept[MalformedURLException] {
          urlRouter ! new URL("dud!")
        }
      }
    }
  }

}
