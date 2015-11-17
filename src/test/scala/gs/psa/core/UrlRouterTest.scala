package gs.psa.core

import java.net.MalformedURLException
import java.net.URL

import org.scalatest.SpecLike

import akka.actor.{ActorSystem, actorRef2Scala}
import akka.testkit.{ImplicitSender, TestKit}

/**
 * @author Sebastian Gerau
 */
class UrlRouterTest extends TestKit(ActorSystem()) with SpecLike with PsaCoreActors 
with PsaCore with ImplicitSender {
  import UrlRouter._
  
  object `UrlRouter` {
    object `when processing an invalid URL` {
      def `should produce a MalformedURLException when invoked` {
        intercept[MalformedURLException] {
          urlRouter ! new URL("dud!")
        }
      }
    }
  }

}
