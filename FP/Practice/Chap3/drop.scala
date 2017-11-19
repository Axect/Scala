import fpinscala.datastructures._

object Drop {
  def main(args: Array[String]): Unit = {
    println(drop(temp, 3))
  }

  def drop[A](tl: List[A], n: Int): List[A] = (tl, n) match {
    case (Nil, _) => Nil
    case (xs, 0) => xs
    case (Cons(x, xs), k) => drop(xs, k-1)
  }

  val temp = List(1,2,3,4,5)
}
