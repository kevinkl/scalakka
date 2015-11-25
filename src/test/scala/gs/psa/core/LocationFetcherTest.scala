package gs.psa.core.actors

import org.scalatest.SpecLike

import akka.actor.ActorSystem
import akka.testkit.ImplicitSender
import akka.testkit.TestKit
import gs.psa.core.PsaCore
import gs.psa.core.PsaCoreActors

/**
 * @author Sebastian Gerau
 */
class LocationFetcherTest extends TestKit(ActorSystem()) with SpecLike with PsaCoreActors 
with PsaCore with ImplicitSender {
  import LocationFetcher._

  object `A LocationFetcher` {
    object `when processing a list of potential locations` {
      def `should produce an Array of String values with only true locations` {
        
      }
    }
  }

}
