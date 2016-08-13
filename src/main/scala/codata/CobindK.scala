package khats

import cats.~>


trait CobindK[T[_[_], _]] {

  def coapplyk: CoapplyK[T]

  def cobindk[F[_]]: T[F, ?] ~> T[T[F, ?], ?]

}

object CobindK {

  def apply[T[_[_], _]](implicit a: CobindK[T]): CobindK[T] = a

}