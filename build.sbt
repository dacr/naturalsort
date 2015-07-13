name := "naturalsort"

version := "0.1.3"

organization :="fr.janalyse"

organizationHomepage := Some(new URL("http://www.janalyse.fr"))

//scalaVersion := "2.9.2"
scalaVersion := "2.10.0-RC2"

crossScalaVersions := Seq("2.9.1", "2.9.2")
//crossScalaVersions := Seq("2.10.0-RC2")

//libraryDependencies += "org.scalatest" %% "scalatest" % "1.8" % "test"
libraryDependencies += "org.scalatest" % "scalatest_2.10.0-RC2" % "2.0.M5" % "test"
//libraryDependencies += "org.scalatest" %% "scalatest" % "2.0.M5" % "test"

publishTo := Some(
     Resolver.sftp(
         "JAnalyse Repository",
         "www.janalyse.fr",
         "/home/tomcat/webapps-janalyse/repository"
     ) as("tomcat", new File(util.Properties.userHome+"/.ssh/id_rsa"))
)

