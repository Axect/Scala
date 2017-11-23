sealed trait Option[+A]
case object None extends Option[Nothing]
case class Some[A](get: A) extends Option[A]

object fibo {
  def main(args: Array[String]): Unit = {
    println(fibo(10))
  }

  def add(x: Option[Int], y: Option[Int]): Option[Int] = (x, y) match {
    case (None, _) => y
    case (_, None) => x
    case (Some(a), Some(b)) => Some(a + b)
  }

  def fibo(n: Int): Option[Int] = n match {
    case k if k < 1 => None
    case k if k < 3 => Some(1)
    case k => add(fibo(n-1),fibo(n-2))
  }
}
