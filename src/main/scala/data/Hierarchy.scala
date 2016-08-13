package khats


trait Hierarchy extends Hierarchy3


trait Hierarchy3 extends Hierarchy2 {

  implicit def MonadKBindk[T[_[_], _]](implicit s: MonadK[T]): BindK[T] = s.bindk
  implicit def MonadKApplicativek[T[_[_], _]](implicit s: MonadK[T]): ApplicativeK[T] = s.applicativek
  implicit def MonadKFunctork[T[_[_], _]](implicit s: MonadK[T]): FunctorK[T] = s.applicativek.applyk.functork

}

trait Hierarchy2 extends Hierarchy1 {

  implicit def BindKApplyk[T[_[_], _]](implicit s: BindK[T]): ApplyK[T] = s.applyk
  implicit def BindKFunctork[T[_[_], _]](implicit s: BindK[T]): FunctorK[T] = s.applyk.functork

}

trait Hierarchy1 extends Hierarchy0 {

  implicit def ApplicativeKCoapplyk[T[_[_], _]](implicit s: ApplicativeK[T]) = s.applyk
  implicit def ApplicativeKFunctork[T[_[_], _]](implicit s: ApplicativeK[T]) = s.applyk.functork

}

trait Hierarchy0 {

  implicit def ApplyKFunctork[T[_[_], _]](implicit s: ApplyK[T]) = s.functork

}