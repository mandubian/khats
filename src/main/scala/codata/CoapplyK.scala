package khats

trait CoapplyK[T[_[_], _]] {

  def functork: FunctorK[T]
  def cozipk: CozipK[T]

}


object CoapplyK {

  def apply[T[_[_], _]](implicit c: CoapplyK[T]) = c

}