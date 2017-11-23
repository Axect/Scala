package fpinscala.option

sealed trait Option[+A] {
  def map[B](f: A => B): Option[B] = this match {
    case None => None
    case Some(x) => Some(f(x))
  }

  // TODO #1
  def getOrElse[B >: A](default: => B): B = this match { // >: means super type & => B means lazy B
    case None => default
    case Some(a) => a // What is B?!
  }

  // TODO #2
  def flatMap[B](f: A => Option[B]): Option[B] =
    map(f) getOrElse None // map = Option[B] => ...?
}
case object None extends Option[Nothing]
case class Some[+A](get: A) extends Option[A]