import breeze.linalg._
import breeze.stats.distributions._
import breeze.plot._
import breeze.stats.regression._

object Scatter {
  def main(args: Array[String]): Unit = {
    val dist = new Gaussian(0.0, 1.0)
    val x = linspace(-10.0, 10.0, 100)
    val d = new DenseVector(dist.sample(100).toArray)
    d += x

    val weight = DenseMatrix.horzcat(
      DenseMatrix.ones[Double](100, 1),
      d.toDenseMatrix.t
    )

    val Res = leastSquares(weight, d)
    val Array(a, b) = Res.coefficients.toArray
    val fitted = a :+ (b :* x)

    val Fig = Figure("Scatter with Regression")
    val plt = Fig.subplot(0)
    plt += plot(x, d, '+', colorcode="black")
    plt += plot(x, fitted, colorcode="red")
    Fig.refresh()
  }
}
