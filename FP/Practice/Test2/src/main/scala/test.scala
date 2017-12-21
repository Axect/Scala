import fpinscala.Dlist._
import fpinscala.Dstream._

object Test {
  def main(Args: Array[String]): Unit = {
    val x = List(1,2,3,4,5)
    println(x.take(3))
    println(x.drop(3))
    println(x.headOption)

    val y = Stream(1,2,3,4,5)
    println(y.headOption)
    println(y.take(3))
    println(y.drop(3))
    println(y.take(3).toList)
    println(y.drop(3).toList)
  }
}
