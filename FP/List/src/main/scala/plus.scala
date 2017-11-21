import ADT.List._

object Operation {
  def main(args: Array[String]): Unit = {
    println(plus(temp))
  }

  def plus(l: List[Int]): List[Int] = l match {
    case Nil => Nil
    case Cons(x, xs) => Cons(x+1, plus(xs))
  }

  val temp = List(1,2,3,4,5)
}
