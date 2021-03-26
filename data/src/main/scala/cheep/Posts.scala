package cheep.data

import io.circe.generic.semiauto._
import io.circe.{Decoder, Encoder}

final case class Posts(posts: Iterable[(Id, Post)])
object Posts {
  implicit val postDecoder: Decoder[Posts] = deriveDecoder[Posts]
  implicit val postEncoder: Encoder[Posts] = deriveEncoder[Posts]
}
