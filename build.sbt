
name := "akka-cinammon"

version := "1.0"

scalaVersion := "2.11.8"

val akkaVersion = "2.4.17"

lazy val `akka-cinammon` = project in file(".") enablePlugins (Cinnamon)

// Add the Cinnamon Agent for run and test
cinnamon in run := true
cinnamon in test := true

// Set the Cinnamon Agent log level
cinnamonLogLevel := "INFO"

libraryDependencies ++= Seq(
  Cinnamon.library.cinnamonCHMetrics,
  Cinnamon.library.cinnamonAkka,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "org.scalatest" %% "scalatest" % "3.0.1"
)