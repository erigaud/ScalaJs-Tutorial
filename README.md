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
On utisera les ScalaTags dans la partie [Single Page Application][## Single-Page-Application]

- Pour que les modifications soient prises en compte, il faut utiliser la commande reload 
``` sbt> reload```
- Executer le code pour vérifier l'affichage du "Hello World" 
``` sbt> run```

- Créer un dossier "views" à la racine du projet, pour y mettre les fichiers HTML. On peut y mettre un premier fichier "hello.html", avec le code suivant : 
``` html 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Scala.js Hello, World</title>
</head>
<body>
<!-- include Scala.js compiled code -->
<script type="text/javascript" src="../target/scala-2.12/scalajsapp-fastopt.js"></script>
</body>
</html>
```

- Modifier l'object Hello.scala 
```scala
package tutorial
import org.scalajs.dom
import dom.document

object Hello {
  def main(args: Array[String]): Unit = {
      val parNode = document.createElement("p")
      val textNode = document.createTextNode("Hello, world")
      parNode.appendChild(textNode)
      document.body.appendChild(parNode)

  }
}
```

- Generer le code JS avec ```sbt> fastOptJS```

- Lancer "hello.html" dans le navigateur et observer "Hello, world" s'afficher ! 

## Single Page Application 

- On modifie légèrement le body de views/hello.html 

``` html
<body>
    <div id="root"></div>
    <!-- include Scala.js compiled code -->
    <script type="text/javascript" src="../target/scala-2.12/scalajsapp-jsdeps.js"></script>
    <script type="text/javascript" src="../target/scala-2.12/scalajsapp-fastopt.js"></script>
</body>
```

- On utilise enfin les Scalatags (qu'on avait dans notre build.sbt)
``` scala 
import scalatags.JsDom.all._
```

- On remplace la fonction main : 

``` scala
  def main(args: Array[String]): Unit = {
    val btn = button(
      "Click me",
      onclick := { () =>
        dom.window.alert("Hello, world")
      })

    // intentional overkill to demonstrate scalatags
    val content =
      div(cls := "foo",
        div(cls := "bar",
          h2("Hello"),
          btn
        )
      )

    val root = dom.document.getElementById("root")
    root.innerHTML = ""
    root.appendChild(content.render)

  }
  ```
  On peut donc créer des éléments html facilement : `html <div class="foo">Hello</div>` devient `scala div(cls := "foo","Hello")` par exemple. 
  
  
