import fpinscala.Stream.Stream._

object Cached {
  def main(args: Array[String]): Unit = {
    var t = 1
    val x = cons(expensive(s"Call $t!"), empty)
    val h1 = x.headOption // print!
    t += 1 // SideEffect!
    val h2 = x.headOption // not print!
  }

  def expensive(x: Any):Unit = println(x)
}
