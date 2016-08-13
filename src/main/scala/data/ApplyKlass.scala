package khats


trait ApplyKlass[T[_[_], _]] extends ApplyK[T] with FunctorK[T] {

  def applyk: ApplyK[T] = this
  
}