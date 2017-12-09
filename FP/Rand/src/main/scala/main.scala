import fpinscala.Rand._

object fpmain {
  def main(Args: Array[String]): Unit = {
    val rng = SimpleRNG(42)
    val (n1, rng2) = rng.nextInt
    val (n2, rng3) = rng2.nextInt
    println(n1)
    println(n2)
  }
}
