object Fmain {
  def main(Args: Array[String]): Unit = {
    println("Hello, World!")
  }

  // Not Parallel
  def sum1(ints: Seq[Int]): Int = {
    ints.foldLeft(0)((a, b) => a + b)
  }

  // Parallel
  def sum2(ints: IndexedSeq[Int]): Int = {
    if (ints.size <= 1)
      ints.headOption getOrElse 0 // If exist, then get value if not, 0
    else {
      val (l, r) = ints.splitAt(ints.length/2)
      sum2(l) + sum2(r)
    }
  }
}
