ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.7"

lazy val root = (project in file("."))
  .settings(
    name := "clases-2026-1"
  )

libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
