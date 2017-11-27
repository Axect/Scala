import fpinscala.Stream._

object TakeNDrop {
  def main(args: Array[String]): Unit = {
    val x = Stream(1,2,3,4,5)
    val xt = x.take(3).toList
    val xd = x.drop(3).toList
    println(xt, xd)
  }
}
