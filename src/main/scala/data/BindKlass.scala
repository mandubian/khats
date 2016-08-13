package khats


trait BindKlass[T[_[_], _]] extends BindK[T] with ApplyKlass[T] {

  final def bindk: BindK[T] = this

}