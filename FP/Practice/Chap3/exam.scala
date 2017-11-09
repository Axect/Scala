import fpinscala.datastructures._

object Exam {
  def main(args: Array[String]): Unit = {
    val ans = sum(x)
    println(s"The result of sum is ${ans}")
  }

  def sum(ar: List[Int]): Int = ar match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  val x = List(1,2,3,4,5)
}
