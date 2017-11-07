object LiteralModule {
  def main(args: Array[String]): Unit = {
    val b = lessThan(10, 20)
    println(b)
  }

  // An object which has apply method can be used by function itself
  val lessThan = new Function2[Int, Int, Boolean] {
    def apply(a: Int, b: Int) = a < b
  }
}
