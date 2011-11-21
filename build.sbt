import sbt._

organization := "org.eiennohito"

name := "rogue_test_for_idea"

version := "0.1-SNAPSHOT"

scalaVersion := "2.9.1"

moduleName := "rogue_test_for_idea"

libraryDependencies += "org.scalatest" %% "scalatest" % "1.6.1" % "test"

libraryDependencies ++= {
  val liftVersion = "2.4-M4" // Put the current/latest lift version here
  Seq("net.liftweb" %% "lift-mongodb-record" % liftVersion)
}

libraryDependencies += "com.foursquare" %% "rogue" % "1.0.28" intransitive()

parallelExecution := true