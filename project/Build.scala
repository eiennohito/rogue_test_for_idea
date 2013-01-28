import sbt._
import Keys._

object TestBuild extends Build {
  lazy val rogue = ProjectRef(file("rogue"), "rogue-lift")
  lazy val root = Project("test", base = file("."), dependencies = Seq(rogue))
}
