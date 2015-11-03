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
import gs.psa.actors.UrlContentFetcher.ScrapeUrl
import gs.psa.actors.UrlContentFilter.FilterContent

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
      def `should produce a FilterContent object` {
        val testFetcher = system.actorOf(UrlContentFetcher.props, "testFetcher1")
        val testFileUrl = new File("src/test/resources/test.html").toURI.toURL
        val testScrapeUrl: ScrapeUrl = new ScrapeUrl(testFileUrl)

        testFetcher ! testScrapeUrl

        Thread.sleep(1000)

        expectMsgType[FilterContent]
      }
    }
  }
}
