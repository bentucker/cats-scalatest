import sbtcrossproject.CrossPlugin.autoImport.{CrossType, crossProject}
lazy val catsVersion = "2.1.1"

inThisBuild(
  Seq(
    name := "cats-scalatest",
    organization := "com.ironcorelabs",
    sonatypeProfileName := organization.value,
    developers := List(
      Developer("coltfred", "Colt Frederickson", "coltfred+github@gmail.com", url("http://github.com/coltfred"))
    ),
    homepage := Some(url("http://github.com/ironcorelabs/cats-scalatest")),
    licenses := Seq("Apache-2.0" -> url("http://www.opensource.org/licenses/Apache-2.0")),
    scalaVersion := "2.12.10",
    crossScalaVersions := Seq(scalaVersion.value, "2.13.1")
  )
)

lazy val `cats-scalatest` = crossProject(JVMPlatform, JSPlatform)
  .crossType(CrossType.Full)
  .in(file("."))
  .settings(
    scalacOptions ++= Seq(
      "-deprecation",
      "-unchecked"
    ),
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats-core"   % catsVersion,
      "org.typelevel" %%% "cats-macros" % catsVersion,
      "org.scalatest" %%% "scalatest"   % "3.1.2",
      "com.chuusai"   %%% "shapeless"   % "2.3.3"
    )
  )
