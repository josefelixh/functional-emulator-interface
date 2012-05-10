name := "functional-emulator-interface"

resolvers += "Java.net Repository for Maven" at "http://download.java.net/maven/2"

libraryDependencies += "javax.servlet" % "servlet-api" % "2.5" % "provided"

libraryDependencies += "org.scalatest" %% "scalatest" % "1.7.1" % "test"

seq(webSettings :_*)

libraryDependencies += "org.mortbay.jetty" % "jetty" % "6.1.22" % "container"

libraryDependencies += "org.apache.httpcomponents" % "httpcore-nio" % "4.1.4"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.10"
)