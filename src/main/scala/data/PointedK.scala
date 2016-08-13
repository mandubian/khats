package khats

import cats.~>


trait PointedK[T[_[_], _]] {
  def purek[F[_]]: F ~> T[F, ?]
}

object PointedK {

  def apply[T[_[_], _]](implicit p: PointedK[T]): PointedK[T] = p

}