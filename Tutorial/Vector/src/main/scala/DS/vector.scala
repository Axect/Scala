package DS

import Tensor._

sealed trait Tensor[+A] {
  def toContra: VecTup[A] = this match {
    case Null => (0, Null)
    case _ => (1, this)
  }

  def toCo: VecTup[A] = this match {
    case Null => (0, Null)
    case _ => (-1, this)
  }
}
case object Null extends Tensor[Nothing]
case class Vector[A](head: A, tail: Tensor[A]) extends Tensor[A]

object Tensor {
  type VecTup[+A] = (Int, Tensor[A])
  def contra[A](head: A, tail: Tensor[A]): VecTup[A] = {
    (1, Vector(head, tail))
  }
  def covector[A](head: A, tail: Tensor[A]): VecTup[A] = {
    (-1, Vector(head, tail))
  }

  def apply[A](as: A*): Tensor[A] = {
    if (as.isEmpty) Null
    else Vector[A](as.head, apply(as.tail:_*))
  }
}
