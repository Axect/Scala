import fpinscala.Stream._

object Cached {
  def main(args: Array[String]): Unit = {
    val x = cons(expensive(1), empty)
    val h1 = x.headOption // Just one caching!
    val h2 = x.headOption // So it doesn't print!
    println()
  }

  def expensive(x: Any):Unit = println(x)
}
