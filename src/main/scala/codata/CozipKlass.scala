package khats

trait CozipKlass[T[_[_], _]]
  extends CozipK[T] {

  final def cozipk: CozipK[T] = this

}