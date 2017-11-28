import breeze.linalg._

object Test {
  def main(args: Array[String]): Unit = {
    val x = DenseVector.zeros[Double](5)
    x(1) = 2
    x(3 to 4) :=   .5
    x(0 to 1) := DenseVector(.1, .2)
    println(x)

    val m = DenseMatrix.zeros[Int](5, 5)
    println(m.rows, m.cols)
    println(m(::, 1))
    m(4, ::) := DenseVector(1,2,3,4,5).t // transpose
    println(m)
    println()
    m(0 to 1, 0 to 1) := DenseMatrix((3,1),(-1,-2))
    println(m)
  }
}
