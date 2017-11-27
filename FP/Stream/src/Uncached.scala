import fpinscala.Stream._

object Uncached {
  def main(args: Array[String]): Unit = {
    val tl = Empty
    val x = Cons(() => expensive(1), () => tl)
    val h1 = x.headOption
    val h2 = x.headOption
    println()
  }

  def expensive(x: Any):Unit = println(x)
}
