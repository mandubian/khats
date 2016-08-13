package khats


sealed trait CopKBuild

class :|:[H[_], T <: CopKBuild](implicit val toCop:ToCopK[H :|: T]) extends CopKBuild

trait :||:[T1 <: CopKBuild, T2 <: CopKBuild] extends CopKBuild

trait NilK extends CopKBuild


class CopKBuilder[CopKBuild0 <: CopKBuild, C[_] <: CopK[_]] {
  type Cop[t] = C[t]
}

object CopKBuilder {
  def apply[CopKBuild0 <: CopKBuild](implicit toCop:ToCopK[CopKBuild0]) = new CopKBuilder[CopKBuild0, toCop.Cop] {}
}

trait ToCopK[F <: CopKBuild] {
  type Cop[_] <: CopK[_]
}

object ToCopK extends LowerToCopK {

  def apply[F <: CopKBuild](implicit toCopK: ToCopK[F]) = toCopK

  type Aux[F <: CopKBuild, C[_] <: CopK[_]] = ToCopK[F] {
    type Cop[t] = C[t]
  }

  implicit val NilK: ToCopK.Aux[NilK, CNilK] = new ToCopK[NilK] {
    type Cop[t] = CNilK[t]
  }

  implicit def one[H[_]]: ToCopK.Aux[:|:[H, NilK], In1[H, ?]] =
    new ToCopK[:|:[H, NilK]] {
      type Cop[t] = In1[H, t]
    }

  implicit def two[H[_], H2[_]]: ToCopK.Aux[:|:[H, :|:[H2, NilK]], In2[H, H2, ?]] =
    new ToCopK[:|:[H, :|:[H2, NilK]]] {
      type Cop[t] = In2[H, H2, t]
    }

  implicit def three[H[_], H2[_], H3[_]]: ToCopK.Aux[:|:[H, :|:[H2, :|:[H3, NilK]]], In3[H, H2, H3, ?]] =
    new ToCopK[:|:[H, :|:[H2, :|:[H3, NilK]]]] {
      type Cop[t] = In3[H, H2, H3, t]
    }

}

trait LowerToCopK {

  implicit def rec[H[_], T <: CopKBuild, C[_] <: CopK[_], O[_] <: CopK[_]](
    implicit
      next: ToCopK.Aux[T, C]
    , prep: PrependHK.Aux[H, C, O]
  ): ToCopK.Aux[:|:[H, T], O] =
    new ToCopK[:|:[H, T]] {
      type Cop[t] = O[t]
    }

  implicit def merge[T1 <: CopKBuild, T2 <: CopKBuild, C1[_] <: CopK[_], C2[_] <: CopK[_]](
    implicit
      toCopK1: ToCopK.Aux[T1, C1]
    , toCopK2: ToCopK.Aux[T2, C2]
  ): ToCopK.Aux[:||:[T1, T2], AppendK[C1, C2, ?]] =
    new ToCopK[:||:[T1, T2]] {
      type Cop[t] = AppendK[C1, C2, t]
    }

}
