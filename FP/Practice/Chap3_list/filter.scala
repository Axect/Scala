import fpinscala.datastructures._

object Filter {
  def main(args: Array[String]): Unit = {
    println(filter(temp)(x => x%2 == 0))
  }

  def filter[A](l: List[A])(f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case Cons(x, xs) if f(x) => Cons(x, filter(xs)(f))
    case Cons(x, xs) if !f(x) => filter(xs)(f)
  }

  val temp = List(1,2,3,4,5,6)
}
