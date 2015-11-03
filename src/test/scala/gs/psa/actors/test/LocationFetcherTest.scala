package gs.psa.actors.test

import org.scalatest.SpecLike

import akka.actor.ActorSystem
import akka.testkit.ImplicitSender
import akka.testkit.TestKit

/**
 * @author Sebastian Gerau
 */
class LocationFetcherTest(_system: ActorSystem) extends TestKit(_system) with ImplicitSender 
  with SpecLike {

  def this() = this(ActorSystem("LocationFetcherTest"))
  
  object `A LocationFetcher` {
    object `when processing a list of potential locations` {
      def `should produce an Array of String values with only true locations` {
        
      }
    }
  }
}
