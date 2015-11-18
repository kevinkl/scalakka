package gs.psa.core.actors

import java.io.File
import java.net.MalformedURLException
import java.net.URL

import org.scalatest.SpecLike

import akka.actor.{ActorSystem, actorRef2Scala}
import akka.testkit.{ImplicitSender, TestKit}
import gs.psa.core.{PsaCore, PsaCoreActors}
import gs.psa.core.actors.UrlContentFetcher.ScrapeUrl
import gs.psa.core.actors.UrlContentFilter.FilterContent

/**
 * @author Sebastian Gerau
 */
class UrlContentFetcherTest extends TestKit(ActorSystem()) with SpecLike with PsaCoreActors 
with PsaCore with ImplicitSender {
  import UrlContentFetcher._

  object `A UrlContentFetcher` {
    object `when processing an invalid URL` {
      def `should produce a MalformedURLException when invoked` {
        intercept[MalformedURLException] {
          urlContentFetcher ! new URL("dud!")
        }
      }
    }

    object `when processing a valid URL` {
      def `should produce a String of the entire content of the given URL` {
        val testFileUrl = new File("src/test/resources/test.html").toURI.toURL
        val testScrapeUrl: ScrapeUrl = new ScrapeUrl(testFileUrl)

        urlContentFetcher ! testScrapeUrl

        Thread.sleep(1000)

        expectMsgType[FilterContent]
      }
    }
  }

}
