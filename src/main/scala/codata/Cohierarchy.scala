package khats


trait Cohierarchy extends Cohierarchy3

trait Cohierarchy3 extends Cohierarchy2 {

  implicit def ComonadKBindk[T[_[_], _]](implicit s: ComonadK[T]): CobindK[T] = s.cobindk
  implicit def ComonadKApplicativek[T[_[_], _]](implicit s: ComonadK[T]): CoapplicativeK[T] = s.coapplicativek
  implicit def ComonadKFunctork[T[_[_], _]](implicit s: ComonadK[T]): FunctorK[T] = s.coapplicativek.coapplyk.functork

}

trait Cohierarchy2 extends Cohierarchy1 {

  implicit def CobindKApplyk[T[_[_], _]](implicit s: CobindK[T]): CoapplyK[T] = s.coapplyk
  implicit def CobindKFunctork[T[_[_], _]](implicit s: CobindK[T]): FunctorK[T] = s.coapplyk.functork

}


trait Cohierarchy1 extends Cohierarchy0 {

  implicit def CoapplicativeKCoapplyk[T[_[_], _]](implicit s: CoapplicativeK[T]) = s.coapplyk
  implicit def CoapplicativeKFunctork[T[_[_], _]](implicit s: CoapplicativeK[T]) = s.coapplyk.functork

}

trait Cohierarchy0 {

  implicit def CoapplyKFunctork[T[_[_], _]](implicit s: CoapplyK[T]) = s.functork

}