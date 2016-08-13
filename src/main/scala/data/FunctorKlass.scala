package khats

import cats.~>


trait FunctorKlass[T[_[_], _]]
  extends FunctorK[T] {
  
  final def functork: FunctorK[T] = this
}
