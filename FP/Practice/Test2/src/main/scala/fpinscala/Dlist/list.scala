package fpinscala.Dlist

sealed trait List[+A] {
  def headOption: Option[A] = this match {
    case Cons(h, t) => Some(h)
    case Nil => None
  }

  def take(n: Int): List[A] = (this, n) match {
    case (_, 0) => Nil
    case (Nil, _) => Nil
    case (Cons(h,t), n) => Cons(h, t.take(n-1))
  }

  def drop(n: Int): List[A] = this match {
    case _ if n == 0 => this
    case Nil => Nil
    case Cons(h, t) => t.drop(n-1)
  }
}
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail:_*))
  }
}
