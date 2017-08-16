import sbt.IvyConsole.Dependencies

name := "Test2"

version := "1.0"

scalaVersion := "2.12.3"

lazy val accounts = project.
  settings(libraryDependencies ++= Dependencies.commonDependencies)

lazy val apiResource = project.
  dependsOn(accounts,checkout,inventory,notification).
  aggregate(accounts,checkout,inventory,notification).
  settings(libraryDependencies ++= Dependencies.commonDependencies)

lazy val checkout = project.
  settings(libraryDependencies ++= Dependencies.commonDependencies)

lazy val dashboard = project.
  dependsOn(apiResource).
  aggregate(apiResource).
  settings(libraryDependencies ++= Dependencies.commonDependencies)

lazy val inventory = project.
  settings(libraryDependencies ++= Dependencies.commonDependencies)

lazy val notification = project.
  settings(libraryDependencies ++= Dependencies.commonDependencies)

lazy val root = (project in file(".")).
  aggregate(accounts, apiResource, checkout, dashboard, inventory, notification)