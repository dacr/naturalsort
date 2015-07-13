name := "naturalsort"

version := "0.1.9-SNAPSHOT"

organization :="fr.janalyse"

organizationHomepage := Some(new URL("http://www.janalyse.fr"))

scalaVersion := "2.11.7"

scalacOptions ++= Seq( "-deprecation", "-unchecked", "-feature")

crossScalaVersions := Seq("2.10.5", "2.11.7")

libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "2.2.+" % "test"
)

