package gs.psa.core.actors

import java.io.File

import scala.io.Source

import org.scalatest.SpecLike

import akka.actor.{ActorSystem, actorRef2Scala}
import akka.testkit.{ImplicitSender, TestKit}
import gs.psa.core.{PsaCore, PsaCoreActors}
import gs.psa.core.actors.LocationFetcher.Locations
import gs.psa.core.actors.UrlContentFilter.FilterContent

/**
 * @author Sebastian Gerau
 */
class UrlContentFilterTest extends TestKit(ActorSystem()) with SpecLike with PsaCoreActors 
with PsaCore with ImplicitSender {
  import UrlContentFilter._

  object `A UrlContentFilter` {
    object `when processing content of a valid URL` {
      def `should produce an Array of String values each starting with a capital letter` {
        val testFile = new File("src/test/resources/test.html")
        val testFileContent = Source.fromFile(testFile).getLines.mkString
        val testFilterContent: FilterContent = new FilterContent(testFileContent)

        urlContentFilter ! testFilterContent

        Thread.sleep(1000)

        expectMsgType[Locations]
      }
    }
  }

}
