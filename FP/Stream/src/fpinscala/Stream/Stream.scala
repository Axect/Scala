package fpinscala.Stream

sealed trait Stream[+A] {
  def headOption: Option[A] = this match {
    case Empty => None
    case Cons(h, t) => Some(h())
  }

  def take(n: Int): Stream[A] = (this, n) match {
    case (Cons(x, xs), 0) => cons(x(), xs())
    case (Cons(x, xs), k) => cons(x(), xs().take(k-1))
    case _ => empty
  }

  def drop(n: Int): Stream[A] = this match {
    case Cons(x, xs) if  n != 0 => xs().drop(n-1)
    case Cons(x, xs) if n == 0 => cons(x(), xs())
    case _ => empty
  }

  def toList: List[A] = this match {
    case Empty => Nil
    case Cons(x, xs) => x() :: xs().toList
  }
}
case object Empty extends Stream[Nothing]
case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A] // () => A is Thunk