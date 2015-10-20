package gs.psa.actors.test

import java.io.File

import scala.io.Source

import org.scalatest.SpecLike

import akka.actor.ActorSystem
import akka.actor.actorRef2Scala
import akka.testkit.ImplicitSender
import akka.testkit.TestKit
import gs.psa.actors.LocationFetcher

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
