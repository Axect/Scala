import fpinscala.datastructures._

object Tail {
  def main(args: Array[String]): Unit = {
    println(tail(temp))
    println(setHead(temp, 10))
  }

  def tail[A](tl: List[A]): List[A] = tl match {
    case Nil => Nil
    case Cons(x, xs) => xs
  }

  def setHead[A](tl: List[A], word: A): List[A] = tl match {
    case Nil => Cons(word, Nil)
    case Cons(x, xs) => Cons(word, xs)
  }

  val temp = List(1,2,3,4,5)
}
