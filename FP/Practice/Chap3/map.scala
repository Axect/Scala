import fpinscala.datastructures._

object Map {
  def main(args: Array[String]): Unit = {
    println(map(temp)(x => (x.toFloat / 2)))
  }

  def map[A, B](l: List[A])(f: A => B): List[B] = l match {
    case Nil => Nil
    case Cons(x, xs) => Cons(f(x), map(xs)(f))
  }

  val temp = List(1,2,3,4,5)
}
