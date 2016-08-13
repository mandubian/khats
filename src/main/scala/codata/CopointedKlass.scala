package khats

trait CopointedKlass[T[_[_], _]]
  extends CopointedK[T] {

  final def copointedk: CopointedK[T] = this

}