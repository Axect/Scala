package fpinscala.Dstream

sealed trait Stream[+A] {
  def headOption: Option[A] = this match {
    case Cons(h, t) => Some(h())
  }

  def take(n: Int): Stream[A] = this match {
    case Cons(h, t) if n > 0 => Cons(()=>h(), ()=>t().take(n-1))
    case _ => Empty
  }

  def drop(n: Int): Stream[A] = this match {
    case Cons(h,t) if n > 0 => t().drop(n-1)
    case _ => this
  }

  def toList: List[A] = this match {
    case Cons(h,t) => h() :: t().toList
    case Empty => Nil
  }

  def map[B](f: A => B): Stream[B] = this match {
    case Cons(h, t) => Cons(() => f(h()), () => t().map(f))
    case Empty => Empty
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
