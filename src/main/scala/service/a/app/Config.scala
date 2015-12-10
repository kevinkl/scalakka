package service.a.app

import com.typesafe.config.ConfigFactory

trait Config {
  
  private val config = ConfigFactory.load()

  private val akkaConf = config.getConfig("akka")
  val akkaLogLevel = akkaConf.getString("loglevel")
  
  private val httpConf = config.getConfig("http")
  val httpInterface = httpConf.getString("interface")
  val httpPort = httpConf.getString("port")
  
}