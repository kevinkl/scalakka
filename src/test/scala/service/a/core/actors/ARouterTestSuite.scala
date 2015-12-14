package service.a.core.actors

import akka.testkit.TestKit
import org.scalatest.SpecLike
import akka.testkit.ImplicitSender
import akka.actor.Props
import akka.actor.ActorSystem

class ARouterTestSuite extends TestKit(ActorSystem()) with SpecLike with ImplicitSender {
  import ARouter._

  object `An ARouter` {
    object `when being send a random message` {
      def `replies with a "Not yet implemented" message` {
        val aRouter = system.actorOf(Props[ARouter])
        aRouter ! "Find the answer to everything"
        expectMsg("Not yet implemented")
      }
    }
  }

}