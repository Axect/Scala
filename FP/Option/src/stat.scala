import fpinscala.option._
import math.pow

object stat {
  def main(args: Array[String]): Unit = {
    val result = abs0(variance(temp)) match {
      case None => 0.0
      case Some(x) => x
    }
    println(result)
  }

  def lift[A, B](f: A => B): Option[A] => Option[B] = _ map f // _ map f is Lambda function (Option[A] in _)

  def mean(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)

  def variance(xs: Seq[Double]): Option[Double] = {
    mean(xs) flatMap (m => mean(xs.map(x => math.pow(x-m, 2))))
  }

  def abs0: Option[Double] => Option[Double] = lift(math.abs)

  val temp = Seq(-1.0,2.0,3.0,4.0)
}