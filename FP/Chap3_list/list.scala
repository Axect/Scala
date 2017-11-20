package ADT


sealed trait List[+A] // + means Covariant
case object Nil extends List[Nothing] // List[Nothing] means empty list
case class Cons[+A](head: A, tail: List[A]) extends List[A]


object List {
  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }
}
