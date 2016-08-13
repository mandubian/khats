package khats

import cats.~>


trait FunctorK[T[_[_], _]] {
  def mapk[F[_], G[_]](tfa: F ~> G): T[F, ?] ~> T[G, ?]
}


object FunctorK {

  def apply[T[_[_], _]](implicit f: FunctorK[T]): FunctorK[T] = f
  
}