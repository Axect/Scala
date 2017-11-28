import breeze.linalg._
import breeze.numerics._
import breeze.plot._

object Plot {
  def main(args: Array[String]): Unit = {
    val x = linspace(-4.0, 4.0, 200)
    val fx = sigmoid(x)
    val f2x = sigmoid(2.0 * x)
    val f10x = sigmoid(10.0 * x)

    val fig = Figure()
    val plt = fig.subplot(0)

    plt += plot(x, fx)
    plt += plot(x, f2x, name="S(2x)")
    plt += plot(x, f10x, name="S(10x)")
    plt.legend=true
    fig.refresh()
  }
}
