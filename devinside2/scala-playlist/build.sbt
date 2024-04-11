version := "0.0.1-SNAPSHOT"

scalaVersion := "2.12.18"

ThisBuild / watchTriggeredMessage := Watch.clearScreenOnTrigger

scalacOptions ++= Seq (
    "-deprecation",
    "-feature",
    "-unchecked"
)
