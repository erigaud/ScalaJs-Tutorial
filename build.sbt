name := "ScalaJsApp"

version := "0.1"

scalaVersion := "2.12.4"

enablePlugins(ScalaJSPlugin)
scalaJSUseMainModuleInitializer := true   // this is an application with a main method



libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.7"

libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.6.7"
