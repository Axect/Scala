object ComposeModule {
  def main(args: Array[String]): Unit = {
    val f = (x: Double) => math.Pi / 2 - x
    val cos1 = compose(math.sin, f)
    println(cos1(math.Pi/2))

    val cos2 = f andThen math.sin
    println(cos2(math.Pi/2)) 
  }

  def compose[A,B,C](f: B => C, g: A => B): A => C = {
    (a: A) => f(g(a))
  }
}
