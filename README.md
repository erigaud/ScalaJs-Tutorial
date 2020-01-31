# ScalaJs-Tutorial

## Versions 

JDK 1.8
sbt 1.3
Scala 2.12

## Mettre en place le projet 

- Créer un nouveau projet Scala avec sbt 
- Créer projet/plugins.sbt et y ajouter la ligne 

``` addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.28") ```

- Ajouter code suivant dans build.sbt 

``` sbt
name := "ScalaJsApp"

version := "0.1"

scalaVersion := "2.12.4"

enablePlugins(ScalaJSPlugin)
scalaJSUseMainModuleInitializer := true   // application ayant une méthode main
```
- Créer un premier Objet Scala, dans un package "tutorial" : src/main/scala/tutorial/Hello.scala


``` scala
package tutorial

object Hello1 {
  def main(args: Array[String]): Unit = {
    println("Hello, world")
  }
}
```
- Ajouter de nouvelles dépendances dans build.sbt, pour pouvoir travailler avec le DOM et les ScalaTags

``` sbt
libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.7"
libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.6.7"
```

- Pour que les modifications soient prises en compte, il faut utiliser la commande reload 
``` sbt> reload```
