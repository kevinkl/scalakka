package service.a.app

import org.scalatest.SpecLike

import akka.actor.ActorSystem
import akka.testkit.TestKit

class BConfigTestSuite extends TestKit(ActorSystem()) with SpecLike with BConfig {

  object `A BConfig` {
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
      
      def `should have a default "http.interface" value of "0.0.0.0"` {
        assert(interface.equals("0.0.0.0"))
      }
      
      def `should have attribute "akka.port" set` {
        assert(port.nonEmpty)
      }
      
      def `should have a default "http.port" value of "11012"` {
        assert(port.equals("11012"))
      }
    }
  }

}