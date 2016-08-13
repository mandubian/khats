package khats

trait ZipKlass[T[_[_], _]] extends ZipK[T] {

  final def zipk: ZipK[T] = this
}