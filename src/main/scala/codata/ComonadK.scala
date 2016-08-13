package khats


trait ComonadK[T[_[_], _]] {

  def cobindk: CobindK[T]
  def coapplicativek: CoapplicativeK[T]

}