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
  
  def this() = this(ActorSystem("UrlContentFetcherTest"))
  
  object `A UrlContentFetcher` {
    object `when processing an invalid URL` {
      def `should produce a MalformedURLException when invoked` {
        val testFetcher = system.actorOf(UrlContentFetcher.props, "testFetcher0")

        intercept[MalformedURLException] {
          testFetcher ! new URL("dud!")
        }
      }
    }

    object `when processing a valid URL` {
      def `should produce a String of the entire content of the given URL` {
        val testFetcher = system.actorOf(UrlContentFetcher.props, "testFetcher1")
        val testUrl: URL = new File("src/test/resources/test.html").toURI().toURL()

        testFetcher ! testUrl

        Thread.sleep(1000)

        expectMsgType[String]
      }
    }
  }
}