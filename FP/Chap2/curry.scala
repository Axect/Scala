import math.pow

object CurryModule {
  def main(args: Array[String]): Unit = {
    // Partial
    val timesTwo = partial1(2, multiply)
    println(timesTwo(3))

    // Curry
    val power = curry(f1) // power is function of function
    val powerOfTwo = power(2) // powerOfTwo is function (2^x)
    println(powerOfTwo(10))
  }

  // ===========================================================================
  // Source functions
  // ===========================================================================
  def partial1[A, B, C](a: A, f: (A, B) => C): B => C = {
    (b: B) => f(a, b) // Uniquely determined!
  }

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    (a: A) => ((b: B) => f(a, b))
  }
  // ===========================================================================
  // Test Functions
  // ===========================================================================
  def f1(x: Int, y: Int): Int = {
    pow(x, y).toInt
  }

  def multiply(x: Int, y: Int) = {
    x * y
  }
}
