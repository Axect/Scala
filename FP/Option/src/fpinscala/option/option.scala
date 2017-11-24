package fpinscala.option

sealed trait Option[+A] {
  def map[B](f: A => B): Option[B] = this match {
    case None => None
    case Some(x) => Some(f(x))
  }

  def getOrElse[B >: A](default: => B): B = this match { // >: means super type & => B means lazy B
    case None => default
    case Some(a) => a // What is B?!
  }

  def flatMap[B](f: A => Option[B]): Option[B] =
    map(f) getOrElse None

  def filter(f: A => Boolean): Option[A] = this match {
    case Some(a) if f(a) => Some(a)
    case Some(a) if !f(a) => None
  }
}

case object None extends Option[Nothing]
case class Some[+A](get: A) extends Option[A]