package service.a.app

import com.typesafe.config.ConfigFactory

trait AConfig {
  
  private val aConfig = ConfigFactory.load("applicationA.conf")

  private val akka = aConfig.getConfig("serviceA.akka")
  val logLevel = akka.getString("loglevel")
  val stdOutLogLevel = akka.getString("stdout-loglevel")
  val logConfigOnStart = akka.getString("log-config-on-start")
  
  private val http = aConfig.getConfig("serviceA.http")
  val interface = http.getString("interface")
  val port = http.getString("port")
  
}