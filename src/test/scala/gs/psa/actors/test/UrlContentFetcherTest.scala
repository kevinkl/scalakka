package gs.psa.actors.test

import java.io.File
import java.net.MalformedURLException
import java.net.URL

import org.scalatest.SpecLike

import akka.actor.ActorSystem
import akka.actor.actorRef2Scala
import akka.testkit.ImplicitSender
import akka.testkit.TestKit
import gs.psa.actors.UrlContentFetcher

/**
 * @author Sebastian Gerau
 */
class UrlContentFetcherTest(_system: ActorSystem) extends TestKit(_system) with ImplicitSender 
  with SpecLike {
  
  def this() = this(ActorSystem("UrlActorTest"))
  
  object `A UrlActor` {
    object `when processing an invalid URL` {
      def `should produce a MalformedURLException when invoked` {
        val fetcher = system.actorOf(UrlContentFetcher.props, "urlActor")

        intercept[MalformedURLException] {
          fetcher ! new URL("dud!")
        }
      }
    }

    object `when processing a valid URL` {
      def `should produce an Array of string values each starting with a capital letter` {
        val fetcher = system.actorOf(UrlContentFetcher.props, "testUrlActor")
        val url: URL = new File("src/test/resources/test.html").toURI().toURL()

        fetcher ! url

        Thread.sleep(1000)

        val answer = Array("This")
        expectMsgType[Array[String]]
      }
    }
  }
}
