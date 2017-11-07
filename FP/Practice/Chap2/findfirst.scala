object FindModule {
  def main(args: Array[String]): Unit = {
    val result = findFirst(Array(7, 9, 13), (x: Int) => x == 9)
    println(result)
  }

  def findFirst[A](list: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n >= list.length) -1 // -1 means false
      else if (p(list(n))) n // n is true -> Find!
      else loop(n+1) // n is not true -> find n+1
    }
    loop(0)
  }
}
