import System.nanoTime

object FStream {
  def main(Args: Array[String]): Unit = {
    println(s"${elapsed}sec")
    println(s"${elapsed2}sec")
  }

  val elapsed = {
    val t = nanoTime
    val x = from(1).take(1E+06.toInt)
    x.map(x => x*x).filter(_%2 == 0)
    (nanoTime - t) / 1e9d
  }

  val elapsed2 = {
    val t = nanoTime
    val x = (1 to 1E+06.toInt).toList
    x.map(x => x*x).filter(_%2 == 0)
    (nanoTime - t) / 1e9d
  }

  // Infinite Stream
  def from(n: Int): Stream[Int] = Stream.cons(n, from(n+1))
}
  // Stream : 0.001s
  // List : 0.02 s
