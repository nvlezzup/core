import sbt._

class WicketScalaParent(info: ProjectInfo) extends ParentProject(info)
{
  val localRepo = "Local Maven Repository" at "file://"+Path.userHome+"/.m2/repository"
  // val junitD = "junit" % "junit" % "4.8.2" % "test->default"
  // val jettyD = "org.mortbay.jetty" % "jetty" % "6.1.26" % "test->default"

  lazy val wicketScalaCore = project("wicket-scala", "Wicket Scala Core", new WicketScalaProject(_))
  lazy val wicketScalaSample = project("wicket-scala-sample", "Wicket Scala Sample", new WicketSampleProject(_), wicketScalaCore)
//  lazy val wicketScalaSample = project("sample", "Wicket Scala Sample", new WicketSampleProject(_), wicketScalaCore)

	class WicketScalaProject(info: ProjectInfo) extends DefaultProject(info)
	{
      override def compileOptions = Unchecked :: super.compileOptions.toList

	  val localRepo = "Local Maven Repository" at "file://"+Path.userHome+"/.m2/repository"
	  // val wicketScala = "org.wicketstuff.scala" % "wicket-scala" % "1.5-SNAPSHOT"
	  val junitD = "junit" % "junit" % "4.8.2" % "test->default"
	  val jettyD = "org.mortbay.jetty" % "jetty" % "6.1.26" % "test->default"

	  val specsD = "org.scala-tools.testing" % "specs_2.8.1" % "1.6.7.2" % "test->default"
	  val scalaLibD = "org.scala-lang" % "scala-library" % "2.8.1"
	  val scalaTestD = "org.scalatest" % "scalatest" % "1.3" % "test->default"
	  val wicketD = "org.apache.wicket" % "wicket" % "1.5-SNAPSHOT"
	  val wicketExtD = "org.apache.wicket" % "wicket-extensions" % "1.5-SNAPSHOT"
	  val sevletApiD = "javax.servlet" % "servlet-api" % "2.5" % "provided->default"
	  val slf4jD = "org.slf4j" % "slf4j-log4j12" % "1.6.1"

	  override def mainResources = super.mainResources +++ descendents(mainScalaSourcePath ##, -sourceExtensions)

	}


	class WicketSampleProject(info: ProjectInfo) extends DefaultWebProject(info)
	{
      override def compileOptions = Unchecked :: super.compileOptions.toList

	  val localRepo = "Local Maven Repository" at "file://"+Path.userHome+"/.m2/repository"
	  // val wicketScala = "org.wicketstuff.scala" % "wicket-scala" % "1.5-SNAPSHOT"
	  val junit = "junit" % "junit" % "4.8.2" % "test->default"
	  val jettyD = "org.mortbay.jetty" % "jetty" % "6.1.26" % "test->default"
	  val servletD = "javax.servlet" % "servlet-api" % "2.5"
	
	  override def mainResources = super.mainResources +++ descendents(mainScalaSourcePath ##, -sourceExtensions)
	
	}


}
