import breeze.linalg._
import breeze.stats._
import breeze.stats.distributions._
import breeze.plot._
import breeze.numerics._


object stat {
  def main(args: Array[String]): Unit = {
    val dm = DenseMatrix((1.0, 2.0, 3.0), (4.0, 5.0, 6.0))
    val res = dm(::, *) + DenseVector(3.0, 4.0) // * means foreach
    println(res)
    println(mean(dm(*, ::)))

    val dist = new Gaussian(0.0, 1.0)
    val s = dist.sample(10)
    println(meanAndVariance(dist.samples.take(1000)))
    println(dist.mean, dist.variance)

    // Plot
    val x = linspace(-4.0, 4.0, 200)
    val fx = sigmoid(x)
    val fig = Figure()
    val plt = fig.subplot(0)

    plt += plot(x, fx)
    fig.refresh()
    fig.saveas("/home/kavis/Pictures/sigmoid.png")
  }
}
