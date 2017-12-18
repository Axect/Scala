package Tensor

sealed trait Point[+A]
case object Null extends Point[Nothing]

object Tensor {
  def chart[A](p: Point[A]): IndexedSeq[A] = {
    
  }
}
