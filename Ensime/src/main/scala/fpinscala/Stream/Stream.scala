package fpinscala.Stream

sealed trait Stream[+A] {
  def headOption: Option[A] = this match {
    case Empty => None
    case Cons(h, t) => Some(h())
  }

  def toList: List[A] = this match {
    case Empty => Nil
    case Cons(h, t) => h() :: t().toList
  }

  def take(n: Int): Stream[A] = this match {
    case Empty => Empty
    case Cons(h, t) if n > 0 => Cons(() => h(), () => t().take(n-1))
    case _ if n == 0 => Empty
  }

  def drop(n: Int): Stream[A] = this match {
    case Empty => Empty
    case Cons(h, t) if n > 0 => t().drop(n-1)
    case _ if n == 0 => this
  }

  def filter(p: A => Boolean): Stream[A] = this match {
    case Empty => Empty
    case Cons(h, t) if p(h()) => Cons(() => h(), () => t().filter(p))
    case Cons(h, t) if !p(h()) => t().filter(p)
  }
}
case object Empty extends Stream[Nothing]
case class Cons[+A](head: ()=>A, tail: ()=>Stream[A]) extends Stream[A]

object Stream {
  def cons[A](hd: =>A, tl: =>Stream[A]): Stream[A] = {
    lazy val head = () => hd
    lazy val tail = () => tl
    Cons(head, tail)
  }

  def empty[A]: Stream[A] = Empty

  def apply[A](as: A*): Stream[A] = {
    if (as.isEmpty) empty
    else cons(as.head, apply(as.tail:_*))
  }
}
