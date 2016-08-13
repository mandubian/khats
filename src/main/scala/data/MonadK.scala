package khats


trait MonadK[T[_[_], _]] {

  def bindk: BindK[T]
  def applicativek: ApplicativeK[T]

}