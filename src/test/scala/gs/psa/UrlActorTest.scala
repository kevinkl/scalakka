package gs.psa

import java.net.MalformedURLException
import java.net.URL
import org.scalatest.SpecLike
import akka.actor.ActorSystem
import akka.actor.actorRef2Scala
import akka.testkit.TestKit
import scala.concurrent.duration._
import java.io.File
import akka.actor.Props
import akka.testkit.ImplicitSender
import scala.reflect.ClassTag

/**
 * @author Sebastian Gerau
 */
class UrlActorTest(_system: ActorSystem) extends TestKit(_system) with ImplicitSender 
  with SpecLike {
  
  def this() = this(ActorSystem("UrlActorTest"))
  
  object `A UrlActor` {
    object `when processing an invalid URL` {
      def `should produce a MalformedURLException when invoked` {
        val urlActor = system.actorOf(UrlActor.props, "urlActor")
        intercept[MalformedURLException] {
          urlActor ! new URL("dud!")
        }
      }
    }

    object `when processing a valid URL` {
      def `should produce an Array of string values each starting with a capital letter` {
        val urlActor = system.actorOf(UrlActor.props, "testUrlActor")
        val url: URL = new File("src/test/resources/test.html").toURI().toURL()
        urlActor ! url
        Thread.sleep(1000)
        val answer = Array("This")
        expectMsgType[Array[String]]
      }
    }
  }
}
