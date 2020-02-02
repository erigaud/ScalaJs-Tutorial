package tutorial
import org.scalajs.dom
import dom.document
import scalatags.JsDom.all._

object Hello {
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
}

