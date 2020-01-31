# ScalaJs-Tutorial

## Versions 

JDK 1.8
sbt 1.3
Scala 2.12

## Mettre en place le projet 

- Créer un nouveau projet Scala 
- Créer projet/plugins.sbt et y ajouter la ligne 

``` addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.28") ```

- Ajouter code suivant dans build.sbt 

```
name := "ScalaJsApp"

version := "0.1"

scalaVersion := "2.12.4"

enablePlugins(ScalaJSPlugin)
scalaJSUseMainModuleInitializer := true   // this is an application with a main method ```
