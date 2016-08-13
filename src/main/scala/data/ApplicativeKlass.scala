package khats


trait ApplicativeKlass[T[_[_], _]] extends ApplicativeK[T] with ApplyKlass[T] with PointedK[T] {

  final def applicativek: ApplicativeK[T] = this
}