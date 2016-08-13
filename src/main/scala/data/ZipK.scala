package khats

import cats.~>


trait ZipK[T[_[_], _]] {

  // Temporary until we have ProductK
  def zipk2[F[_], G[_]]: λ[t => (T[F, t], T[G, t])] ~> T[λ[t => (F[t], G[t])], ?]

}

object ZipK {

  def apply[T[_[_], _]](implicit c: ZipK[T]): ZipK[T] = c
  
}
