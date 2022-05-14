package cheep.component

import calico.dsl.io.*
import calico.syntax.*
import cats.effect.IO
import fs2.concurrent.SignallingRef

object StringEditor {
  def apply(_name: String, _label: String, string: SignallingRef[IO, String]) =
    div(
      cls := List("py-2"),
      div(label(forId := _name, _label)),
      input(
        typ := "text",
        name := _name,
        value <-- string,
        onChange --> (_.mapToTargetValue.foreach(string.set)),
        cls := List(
          "rounded",
          "border-2",
          "border-gray-300",
          "focus:border-red-500",
          "my-2",
          "p-2"
        )
      )
    )
}
