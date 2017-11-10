import Data.List._

object ListTest {
  def main(args: Array[String]): Unit = {
    println(result)
  }

  def append[A](a1: List[A], a2: List[A]): List[A] = a1 match {
    case Nil => a2
    case Cons(h, t) => Cons(h, append(t, a2))
  }

  def linspace(n: Int): List[Int] = n match {
    case 0 => Nil
    case _ => append(List(n), linspace(n-1))
  }

  val result: List[Int] = {
    val milion = linspace(10)
    milion
  }
}
