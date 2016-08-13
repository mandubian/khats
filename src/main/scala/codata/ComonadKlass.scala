package khats


trait ComonadKlass[T[_[_], _]] extends ComonadK[T] with CobindKlass[T] with CoapplicativeKlass[T] {

  final def comonadk: ComonadK[T] = this

}