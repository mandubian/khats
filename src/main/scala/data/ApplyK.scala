package khats

import cats.~>


trait ApplyK[T[_[_], _]] {

  def functork: FunctorK[T]
  def zipk: ZipK[T]

}


object ApplyK {

  def apply[T[_[_], _]](implicit a: ApplyK[T]): ApplyK[T] = a

}