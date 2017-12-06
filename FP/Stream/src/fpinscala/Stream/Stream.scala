package fpinscala.Stream

import Stream._
import scala.annotation.tailrec

sealed trait Stream[+A] {
  def headOption: Option[A] = this match {
    case Empty => None
    case Cons(h, t) => Some(h()) // Call h()
  }

  def take(n: Int): Stream[A] = (this, n) match {
    case (Cons(x, xs), k) if k > 0 => cons(x(), xs().take(k-1))
    case _ => empty
  }

  @tailrec
  final def drop(n: Int): Stream[A] = this match {
    case Empty => empty
    case _ if n == 0 => this
    case Cons(_, xs) => xs().drop(n-1)
  }

  def toList(): List[A] = this match {
    case Empty => Nil
    case Cons(x, xs) => x() :: xs().toList()
  }
}
case object Empty extends Stream[Nothing]
case class Cons[+A](head: () => A, tail: () => Stream[A]) extends Stream[A] // () => A : Thunk!

object Stream {
  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
    lazy val head = hd
    lazy val tail = tl
    Cons(() => head, () => tail)
  }

  def empty[A]: Stream[A] = Empty

  def apply[A](as: A*): Stream[A] =
    if (as.isEmpty) empty else cons(as.head, apply(as.tail: _*))
}