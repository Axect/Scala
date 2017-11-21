import ADT.List._

object Drop {
  def main(args: Array[String]): Unit = {
    println(drop(temp, 3))
    println(dropWhile(temp, (x: Int) => x == 3))
    println(dropWhile2(temp)(x => x == 3))
  }

  def drop[A](tl: List[A], n: Int): List[A] = (tl, n) match {
    case (Nil, _) => Nil
    case (xs, 0) => xs
    case (Cons(x, xs), k) => drop(xs, k-1)
  }

  def dropWhile[A](tl: List[A], f: A => Boolean): List[A] = tl match {
    case Nil => Nil
    case Cons(x, xs) if (f(x)) => Cons(x, xs)
    case Cons(x, xs) if !(f(x)) => dropWhile(xs, f)
  }

  def dropWhile2[A](tl: List[A])(f: A => Boolean): List[A] = tl match { // 스칼라의 형식 추론 돕기!
    case Cons(x, xs) if !f(x) => dropWhile2(xs)(f)
    case _ => tl
  }

  val temp = List(1,2,3,4,5)
}
