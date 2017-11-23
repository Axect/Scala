object mean {
  def main(args: Array[String]): Unit = {
    println(mean(temp))
  }

  def mean(xs: Seq[Double]): Option[Double] = {
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)
  }

  val temp = Seq(1.0,2.0,3.0)
}
