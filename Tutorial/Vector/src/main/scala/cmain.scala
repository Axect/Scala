import DS._
//import DS.Vector._
//import CoVector._

object cmain {
  def main(args: Array[String]): Unit = {
    val t = Tensor(1,2,3,4)
    val x = t.toContra
    val y = t.toCo
    println(x)
    println(y)
  }
}
