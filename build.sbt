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
    "com.typesafe.akka" %% "akka-actor" % akkaVersion withSources(),
    "com.typesafe.akka" %% "akka-http-core-experimental" % akkaExpVersion withSources(),
    "com.typesafe.akka" %% "akka-http-experimental" % akkaExpVersion withSources(),
    "com.typesafe.akka" %% "akka-http-xml-experimental" % akkaExpVersion withSources(),
    "com.typesafe.akka" %% "akka-stream-experimental" % akkaExpVersion withSources(),
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test" withSources(),
    "org.scalatest" %% "scalatest" % scalaTestVersion % "test" withSources(),
    "io.kamon" %% "kamon-core" % kamonVersion withSources(),
    "io.kamon" %% "kamon-statsd" % kamonVersion withSources()
  )
}

fork in run := true
