import fpinscala.datastructures._

object Fold {
  def main(args: Array[String]): Unit = {
    val t = System.nanoTime
    val result = foldLeft(temp, 0)(_ + _)
    val elapsed = (System.nanoTime - t)/1e9d
    println(result, elapsed)
  }

  def foldLeft[A, B](tl: List[A], z: B)(f: (B, A) => B): B = tl match {
    case Nil => z
    case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
  }

  def createList(tl: List[Int], n: Int): List[Int] = (tl, n) match {
    case (Cons(x, xs), k) if k != 0 => createList(Cons(x+1, Cons(x, xs)), k-1)
    case (Nil, k) => createList(Cons(1, Nil), k-1)
    case (_, 0) => tl
  }

  val temp = createList(Nil, 10000)
}
