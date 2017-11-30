// organization := "com.github.loanptn"

// name := "scala-loan-pattern-library"

// version := "1.1"

// scalaVersion := "2.10.3"

// libraryDependencies ++= Seq(
//   "org.scalatest" % "scalatest_2.10" % "1.9.2" % "test",
//   "org.mockito" % "mockito-all" % "1.8.5"
// )

// seq(bintrayResolverSettings:_*)

// resolvers += bintray.Opts.resolver.repo("hiro0107", "maven")

// seq(bintrayPublishSettings:_*)

// licenses += ("Apache-1.1", url("http://apache.org/licenses/LICENSE-1.1"))

lazy val commonSettings = Seq(
  version in ThisBuild := "1.2",
  organization in ThisBuild := "com.github.loanptn"
)

lazy val root = (project in file("."))
  .settings(
    commonSettings,
//    sbtPlugin := true,
    name := "scala-loan-pattern-library",
	scalaVersion := "2.12.4",
    //description := "<YOUR DESCRIPTION HERE>",
    // This is an example. sbt-bintray requires licenses to be specified 
    // (using a canonical name).
    licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html")),
	resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases",
    libraryDependencies ++= Seq(
//	  "org.scalactic" %% "scalactic" % "3.0.4",
      "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test",
      "org.mockito" % "mockito-all" % "1.10.19" % "test"
    ),
    publishMavenStyle := true,
//    bintrayRepository := "sbt-plugins",
    bintrayOrganization in bintray := None
  )
