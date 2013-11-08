organization := "com.github.loanptn"

name := "scala-loan-pattern-library"

version := "1.1"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.10" % "1.9.2" % "test",
  "org.mockito" % "mockito-all" % "1.8.5"
)

seq(bintrayResolverSettings:_*)

resolvers += bintray.Opts.resolver.repo("hiro0107", "maven")

seq(bintrayPublishSettings:_*)

licenses += ("Apache-1.1", url("http://apache.org/licenses/LICENSE-1.1"))
