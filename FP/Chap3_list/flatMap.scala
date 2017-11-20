import ADT._

object FlatMap {
  def main(args: Array[String]): Unit = {
    println(flatMap(temp)(x => List(x, x)))
  }

  def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] = l match {
    case Nil => Nil
    case Cons(x, xs) => concat(f(x), flatMap(xs)(f))
  }

  def concat[A](l1: List[A], l2: List[A]): List[A] = l1 match {
    case Nil => l2
    case Cons(x1, xs1) => Cons(x1, concat(xs1, l2))
  }

  val temp = List(1,2,3)
}
