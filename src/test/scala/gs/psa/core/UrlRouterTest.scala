package gs.psa.core.actors

import java.net.MalformedURLException
import java.net.URL

import org.scalatest.SpecLike

import akka.actor.{ActorSystem, actorRef2Scala}
import akka.testkit.{ImplicitSender, TestKit}
import gs.psa.core.{PsaCore, PsaCoreActors}

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
