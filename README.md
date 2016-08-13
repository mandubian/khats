# Khats, cats on higher-kinded amphets

This is a study on structures from Category Theory applied to higher-kinded structures.

For example:

```scala
FunctorK[T[_[_], _]]
```

It provides a set of typeclasses for higher-kinded structures based on cats FunctionK/Natural Transformation and following the typeclass design imagined by Alois Cochard in [Scato project](https://github.com/aloiscochard/scato) and also used in [Scalaz 8.0.x branch](https://github.com/scalaz/scalaz/tree/series/8.0.x).

