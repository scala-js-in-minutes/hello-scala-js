enablePlugins(ScalaJSPlugin)

name := "Hello Scala.js"
organization := "org.awesome"
version := "1.0"
scalaVersion := "2.13.1"

scalaJSUseMainModuleInitializer := true
libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.0-M2" % "test"
