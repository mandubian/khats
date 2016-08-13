package khats


trait MonadKlass[T[_[_], _]] extends MonadK[T] with BindKlass[T] with ApplicativeKlass[T] {

  final def monadk: MonadK[T] = this

}