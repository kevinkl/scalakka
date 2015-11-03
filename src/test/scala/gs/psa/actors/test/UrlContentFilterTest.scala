package gs.psa.actors.test

import java.io.File

import scala.io.Source

import org.scalatest.SpecLike

import akka.actor.ActorSystem
import akka.actor.actorRef2Scala
import akka.testkit.ImplicitSender
import akka.testkit.TestKit
import gs.psa.actors.LocationFetcher.Locations
import gs.psa.actors.UrlContentFilter
import gs.psa.actors.UrlContentFilter.FilterContent

/**
 * @author Sebastian Gerau
 */
class UrlContentFilterTest(_system: ActorSystem) extends TestKit(_system) with ImplicitSender
    with SpecLike {

  def this() = this(ActorSystem("UrlContentFilterTest"))

  object `A UrlContentFilter` {
    object `when processing content of a valid URL` {
      def `should produce an Array of String values each starting with a capital letter` {
        val testFilter = system.actorOf(UrlContentFilter.props, "testFilter")
        val testFile = new File("src/test/resources/test.html")
        val testFileContent = Source.fromFile(testFile).getLines.mkString
        val testFilterContent: FilterContent = new FilterContent(testFileContent)

        testFilter ! testFilterContent.content

        Thread.sleep(1000)

        expectMsgType[Locations]
      }
    }
  }
}
