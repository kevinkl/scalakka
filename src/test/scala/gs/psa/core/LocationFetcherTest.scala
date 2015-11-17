package gs.psa.core

import org.scalatest.SpecLike

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}

/**
 * @author Sebastian Gerau
 */
class LocationFetcherTest extends TestKit(ActorSystem()) with SpecLike with PsaCoreActors 
with PsaCore with ImplicitSender {
  import LocationFetcher._

  object `LocationFetcher` {
    object `when processing a list of potential locations` {
      def `should produce an Array of String values with only true locations` {
        
      }
    }
  }
}
