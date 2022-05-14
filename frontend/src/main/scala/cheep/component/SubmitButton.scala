package cheep.component

import calico.dsl.io.*
import cats.effect.IO
import fs2.concurrent.Signal

object SubmitButton {
  def apply(label: String, active: Signal[IO, Boolean], handler: IO[Unit]) =
    val classes = List("rounded", "p-2", "hover:bg-green-400", "text-white")
    input(
      typ := "button",
      value := label,
      cls <-- active.map {
        case true  => "bg-green-600" :: classes
        case false => "bg-gray-400" :: classes
      },
      onClick --> (_.foreach(_ => handler))
    )
}
