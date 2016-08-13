package khats

trait CoapplicativeK[T[_[_], _]] {

  def copointedk: CopointedK[T]
  def coapplyk: CoapplyK[T]
}