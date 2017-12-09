// Import Test Successful! => Just use real Stream
// import fpinscala.Stream._
import Stream.Cons

object test {
  def main(Args: Array[String]): Unit = {
    val x = Stream(1,2,3,4,5,6,7,8,9,10)
    val xTake = x.take(5)
    val xDrop = x.drop(5)
    val y = x.takeWhile(x => x < 6)

    println(s"${xTake}, ${xDrop}")
    println(s"${xTake.toList}, ${xDrop.toList}")
    println(y)
    println(y.toList)
    println(exist(x)(x => x%2 == 0))
    println(x.foldRight(false)((a, b) => a % 2 == 0 || b))
  }

  def exist[A](x: Stream[A])(p: A => Boolean): Boolean = x match {
    case h #:: t => p(h) || exist(t)(p)
    case _ => false
  }
 }
