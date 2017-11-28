import Basic.DataStructure._

object test {
  def main(args: Array[String]): Unit = {
    val x = DVector[Int](0, 1, 2, 3, 4)
    println(x.mkString(","))
  }
}