package service.a.app

import com.typesafe.config.ConfigFactory

trait BConfig {
  
  private val bConfig = ConfigFactory.load("applicationB.conf")

  private val akka = bConfig.getConfig("serviceB.akka")
  val logLevel = akka.getString("loglevel")
  val stdOutLogLevel = akka.getString("stdout-loglevel")
  val logConfigOnStart = akka.getString("log-config-on-start")
  
  private val http = bConfig.getConfig("serviceB.http")
  val interface = http.getString("interface")
  val port = http.getString("port")
  
}