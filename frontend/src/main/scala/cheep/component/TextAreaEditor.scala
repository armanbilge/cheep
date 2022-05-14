package cheep.component

import calico.dsl.io.*
import calico.syntax.*
import cats.effect.IO
import fs2.Stream
import fs2.concurrent.SignallingRef

object TextAreaEditor {
  def apply(
      name: String,
      _label: String,
      _rows: Option[Int],
      _cols: Option[Int],
      text: SignallingRef[IO, String]
  ) =
    div(
      cls := List("py-2"),
      div(label(forId := name, _label)),
      textArea(
        value <-- text,
        onChange --> (_.mapToTargetValue.foreach(text.set)),
        rows <-- Stream.fromOption(_rows),
        cols <-- Stream.fromOption(_cols),
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
