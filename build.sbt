name := """play-spnar"""
organization := "com.example"

version := "1.0-SNAPSHOT"


lazy val root = (project in file(".")).enablePlugins(PlayScala)
  .settings(

  )

scalaVersion := "2.13.14"

jacocoReportSettings := JacocoReportSettings(
  "Jacoco Coverage Report",
  None,
  JacocoThresholds(),
  Seq(JacocoReportFormats.ScalaHTML, JacocoReportFormats.XML), // note XML formatter
  "utf-8"
)
  .withThresholds(
    JacocoThresholds(
      instruction = 30,
      method = 30,
      branch = 13,
      complexity = 30,
      line = 30,
      clazz = 30)
  )

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test

