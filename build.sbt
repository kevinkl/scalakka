name := """scalakka"""

version := "0.1"

scalaVersion := "2.11.7"

enablePlugins(JavaAppPackaging)

libraryDependencies ++= {
  val akkaVersion = "2.4.1"
  val akkaExpVersion = "2.0-M2"
  val scalaTestVersion = "2.2.4"
  val kamonVersion = "0.5.2"
  
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-http-core-experimental" % akkaExpVersion,
    "com.typesafe.akka" %% "akka-http-experimental" % akkaExpVersion,
    "com.typesafe.akka" %% "akka-http-xml-experimental" % akkaExpVersion,
    "com.typesafe.akka" %% "akka-stream-experimental" % akkaExpVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
    "org.scalatest" %% "scalatest" % scalaTestVersion % "test",
    "io.kamon" %% "kamon-core" % kamonVersion,
    "io.kamon" %% "kamon-statsd" % kamonVersion
  )
}

fork in run := true
