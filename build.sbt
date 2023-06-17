name                   := "naturalsort"
organization           := "fr.janalyse"
homepage               := Some(new URL("https://github.com/dacr/naturalsort"))
scmInfo                := Some(ScmInfo(url(s"https://github.com/dacr/naturalsort"), s"git@github.com:dacr/naturalsort.git"))
licenses += "Apache 2" -> url(s"https://www.apache.org/licenses/LICENSE-2.0.txt")

ThisBuild / scalaVersion       := "3.3.0"
ThisBuild / scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")
ThisBuild / crossScalaVersions := Seq("2.10.7", "2.11.12", "2.12.18", "2.13.11", "3.3.0")
// 2.10.x : generates java 6 bytecodes
// 2.11.x : generates java 6 bytecodes
// 2.12.x : generates java 8 bytecodes && JVM8 required for compilation
// 2.13.x : generates java 8 bytecodes && JVM8 required for compilation

libraryDependencies ++= Seq(
  ("org.scalatest" %% "scalatest" % "3.2.16" % Test)
)

Test / testOptions += {
  val rel = scalaVersion.value.split("[.]").take(2).mkString(".")
  Tests.Argument(
    "-oDF", // -oW to remove colors
    "-u",
    s"target/junitresults/scala-$rel/"
  )
}
