package fpinscala

import fpinscala.Stream._

package object Stream {
  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = { // Smart Constructor
    lazy val head = hd // Memoization
    lazy val tail = tl
    Cons(() => head, () => tail)
  }

  def empty[A]: Stream[A] = Empty // For specific type empty constructor

  def apply[A](as: A*): Stream[A] =
    if (as.isEmpty) empty else cons(as.head, apply(as.tail: _*))
}
