object MathModule {
  def main(args: Array[String]): Unit = {
      println(formatFactorial(5))
  }

  def formatFactorial(n: Int): String = {
    val msg = "Factorial of %d is %d"
    msg.format(n, factorial(n))
  }

  def factorial(n: Int): Int = {
    @annotation.tailrec // Check Tail Call Elimination
    def loop(n: Int, prod: Int): Int = {
      if (n <= 0) prod
      else loop(n-1, n*prod)
    }
    loop(n, 1)
  }
}
