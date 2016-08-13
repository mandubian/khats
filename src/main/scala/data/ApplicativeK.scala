package khats


trait ApplicativeK[T[_[_], _]] {

  def applyk: ApplyK[T]
  def pointedk: PointedK[T]

}

object ApplicativeK {

  def apply[T[_[_], _]](implicit a: ApplicativeK[T]): ApplicativeK[T] = a
}