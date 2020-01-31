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

