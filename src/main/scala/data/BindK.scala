package khats

import cats.~>


trait BindK[T[_[_], _]] {

  def applyk: ApplyK[T]

  def bindk[F[_]]: T[T[F, ?], ?] ~> T[F, ?]

}

object BindK {

  def apply[T[_[_], _]](implicit a: BindK[T]): BindK[T] = a

}