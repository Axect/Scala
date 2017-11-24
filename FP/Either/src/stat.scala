import fpinscala.either._

object stat {
  def main(args: Array[String]): Unit = {

  }

  def mean(xs: IndexedSeq[Double]): Either[String, Double] =
    if (xs.isEmpty)
      Left("mean of empty list!")
    else
      Right(xs.sum / xs.length)
}
