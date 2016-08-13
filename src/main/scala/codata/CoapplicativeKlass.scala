package khats

trait CoapplicativeKlass[T[_[_], _]]
  extends CoapplicativeK[T]
  with    CoapplyKlass[T]
  with    CopointedKlass[T] {

  final def coapplicativek: CoapplicativeKlass[T] = this
}
