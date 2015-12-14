name := """scalakka"""

version := "0.1"

scalaVersion := "2.11.7"

libraryDependencies ++= {
  val akkaVersion = "2.4.1"
  val akkaExpVersion = "2.0-M2"
  val scalaTestVersion = "2.2.4"
  
  Seq(
    "com.typesafe.akka" % "akka-actor_2.11" % akkaVersion,
    "com.typesafe.akka" % "akka-stream-experimental_2.11" % akkaExpVersion,
    "com.typesafe.akka" % "akka-http-core-experimental_2.11" % akkaExpVersion,
    "com.typesafe.akka" % "akka-http-experimental_2.11" % akkaExpVersion,
    "com.typesafe.akka" % "akka-testkit_2.11" % akkaVersion % "test",
    "org.scalatest" % "scalatest_2.11" % scalaTestVersion % "test"
  )
}

fork in run := true
