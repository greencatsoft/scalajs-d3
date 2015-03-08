name := "scalajs-d3"

description := "D3.js bindings for Scala.js."

organization := "com.greencatsoft"

version := "0.2-SNAPSHOT"

scalaVersion := "2.11.6"

scalacOptions ++= Seq("-feature","-deprecation")

homepage := Some(url("http://github.com/greencatsoft/scalajs-d3"))

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.8.0")

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if(isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

pomIncludeRepository := { _ => false }

lazy val root = project.in(file(".")).enablePlugins(ScalaJSPlugin)

pomExtra := (
  <licenses>
    <license>
      <name>Apache License 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:greencatsoft/scalajs-d3.git</url>
    <connection>scm:git:git@github.com:greencatsoft/scalajs-d3.git</connection>
  </scm>
  <developers>
    <developer>
      <id>mysticfall</id>
      <name>Xavier Cho</name>
      <url>http://github.com/mysticfall</url>
    </developer>
    <developer>
      <id>mmx900</id>
      <name>Setzer Kim</name>
      <url>https://github.com/mmx900</url>
    </developer>
  </developers>
)
