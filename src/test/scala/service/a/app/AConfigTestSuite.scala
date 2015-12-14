package service.a.app

import org.scalatest.SpecLike

import akka.actor.ActorSystem
import akka.testkit.TestKit

class AConfigTestSuite extends TestKit(ActorSystem()) with SpecLike with AConfig {

  object `A Config` {
    object `when initialized` {
      def `should have attribute "akka.loglevel" set` {
        assert(logLevel.nonEmpty)
      }
      
      def `should have attribute "akka.stdout-loglevel" set` {
        assert(stdOutLogLevel.nonEmpty)
      }
      
      def `should have attribute "akka.log-config-on-start" set` {
        assert(logConfigOnStart.nonEmpty)
      }
      
      def `should have attribute "akka.interface" set` {
        assert(interface.nonEmpty)
      }
      
      def `should have attribute "akka.port" set` {
        assert(port.nonEmpty)
      }
    }
  }

}