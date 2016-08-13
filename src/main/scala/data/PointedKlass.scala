package khats

trait PointedKlass[T[_[_], _]]
  extends PointedK[T] {

  final def pointedk: PointedK[T] = this
}