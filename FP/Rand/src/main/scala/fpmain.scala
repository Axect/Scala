import fpinscala.Rand._

object fpmain {
  type FRand[+A] = RNG => (A, RNG)

  def main(Args: Array[String]): Unit = {
    val rng = SimpleRNG(42)
    val (n1, rng2) = rng.nextInt
    val (n2, rng3) = rng2.nextInt
    println(n1)
    println(n2)

    val n3 = int(rng)
    val n4 = unit(42)
    println(n3)
    println(n4)

    val n5 = nonNegativeEven(rng)
    println(n5)
  }

  val int: FRand[Int] = _.nextInt

  def unit[A](a: A): FRand[A] =
    rng => (a, rng)

  def map[A,B](s: FRand[A])(f: A => B): FRand[B] =
    rng => {
      val (a, rng2) = s(rng)
      (f(a), rng2)
    }

  def nonNegativeEven: FRand[Int] =
    map(nonNegativeInt)(i => i - i % 2)

  def nonNegativeInt(rng: RNG): (Int, RNG) = rng.nextInt match {
    case (i, _) if 0<i && i<Int.MaxValue => rng.nextInt
    case (_, rng2) => rng2.nextInt
  }
}
