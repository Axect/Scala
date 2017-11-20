<h1 style="text-align:center">Functional List</h1>
<p style="text-align:right"><b>Tae Geun Kim</b></p>

## - Definition

> Functional Data Structure is not mutable -> Immutable.  
> For example. `List()` or `Nil` is persistantly immutable.

## - Scala Code

```scala
sealed trait List[+A]
```
* `sealed`: All implementation of trait should be in this file.
* `trait`: Abstract Interface.
* `+`: Variance annotation - declare covaiance
* `A`: Parameter

```scala
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]
```
* Nil = Empty List
* Cons = Constructor of List

```scala
object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x,xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }
}
```
* `object List`: Companion object of List trait
* `sum, prodict`: Pattern matching method
* `apply`: Variadic Function (Nothing or Multiple)
* `*`: Like Arguments
