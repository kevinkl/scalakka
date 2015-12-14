package service.a.core

import akka.testkit.TestKitBase
import org.scalatest.SpecLike

class ACoreBootedTestSuite extends TestKitBase with SpecLike with ACoreBooted {
  
  object `An ACoreBooted` {
    object `when initialized` {
      def `should contain a valid "ActorSystem" named "AService"` {
        assert(system.name.equals("AService"))
      }
    }
  }

}