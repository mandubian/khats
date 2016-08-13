package khats

import cats.~>


trait CopointedK[T[_[_], _]] {
  def copurek[F[_]]: T[F, ?] ~> F
}

object CopointedK {

  def apply[T[_[_], _]](implicit p: CopointedK[T]): CopointedK[T] = p

}