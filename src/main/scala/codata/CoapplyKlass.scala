package khats

trait CoapplyKlass[T[_[_], _]]
  extends CoapplyK[T]
  with    CozipKlass[T]
  with    FunctorKlass[T] {

  final def coapplyk: CoapplyK[T] = this

}
