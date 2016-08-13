package khats

import cats.free.Free

import org.scalatest._

import cats.free.{Free, Trampoline}
import cats.data.Xor
import cats.{~>, Id}

import scala.concurrent._
import scala.concurrent.duration._

import cats.Functor
import cats.std.future._
import cats.std.option._
import cats.std.list._
import ExecutionContext.Implicits.global

import scala.language.reflectiveCalls



sealed trait Foo[F[_], A]

object Foo {

  case class Foo0[F[_], A](val fa: F[A]) extends Foo[F, A]

  implicit val copointedk = new CopointedK[Foo] {
    def copurek[F[_]]: Foo[F, ?] ~> F = new (Foo[F, ?] ~> F) {
      def apply[A](tfa: Foo[F, A]): F[A] = tfa match {
        case Foo0(fa) => fa
      }
    }
  }

  implicit val pointedk = new PointedK[Foo] {
    def purek[F[_]]: F ~> Foo[F, ?] = new (F ~> Foo[F, ?]) {
      def apply[A](fa: F[A]): Foo[F, A] = Foo0(fa) 
    }
  }


  implicit val functork = new FunctorK[Foo] {
    def mapk[F[_], G[_]](nat: F ~> G) = new (Foo[F, ?] ~> Foo[G, ?]) {
      def apply[A](fa: Foo[F, A]): Foo[G, A] = fa match {
        case Foo0(fa) => Foo0(nat(fa))
      }
    }
  }

  implicit val cozipk = new CozipK[Foo] {
    def cozipk2[F[_], G[_]] = new (Foo[In2[F, G, ?], ?] ~> In2[Foo[F, ?], Foo[G, ?], ?]) {
      def apply[A](foo: Foo[In2[F, G, ?], A]):  In2[Foo[F, ?], Foo[G, ?], A] = foo match {
        case Foo0(f) => f match {
          case In2l(l) => In2l(Foo0(l))
          case In2r(r) => In2r(Foo0(r))
        }
      }
    }
  }

}


class KhatsSpec extends FlatSpec with Matchers {

  "KhatsSpec" should "do it" in {
    type C = Option :|: List :|: NilK
    val C = CopKBuilder[C]

    val i = CozipK[Foo].cozipk[C.Cop].apply(Foo.Foo0(In2r(List(5))))
    println(i)
  }

}
