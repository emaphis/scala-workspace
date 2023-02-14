version := "0.0.1"

organization := "leroy development"

scalaVersion := "2.12.17"

ThisBuild / watchTriggeredMessage := Watch.clearScreenOnTrigger

scalacOptions ++= Seq (
    "-deprecation",
    "-feature"
)
