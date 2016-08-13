# Khats, cats on higher-kinded amphets

This is a study on structures from Category Theory applied to higher-kinded structures.

For example:

```scala
type T[_[_], _]

val nat: F ~> G = ???

FunctorK[T].mapk(nat)
```

It provides a set of typeclasses for higher-kinded structures based on cats FunctionK/Natural Transformation and following the typeclass design imagined by Alois Cochard in [Scato project](https://github.com/aloiscochard/scato) and also used in [Scalaz 8.0.x branch](https://github.com/scalaz/scalaz/tree/series/8.0.x).

Do you wonder whether it's useful or just brainfucking?

I wonder too yet the brain effort is fun and I have a few interesting ideas in mind to dig and the code is still very experimental... Let's take it as an exercise of style until it becomes more (or not)!