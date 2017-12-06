import fpinscala.Stream._
import fpinscala.Stream.Stream._

object Uncached {
  def main(args: Array[String]): Unit = {
    var t = 1
    val x = Cons(() => expensive(s"Call $t!"), () => empty)
    val h1 = x.headOption // print!
    t += 1 // SideEffect!
    val h2 = x.headOption // also print!
  }

  def expensive(x: String):Unit = println(x)
}
