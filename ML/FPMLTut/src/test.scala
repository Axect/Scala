import Basic.DataStructure._

object test {
  def main(args: Array[String]): Unit = {
    val x = DVector[Int](0, 1, 2, 3, 4)
    printVector(x)

    val m = DMatrix(DVector(1,2,3), DVector(4,5,6), DVector(7,8,9))
    printMatrix(m)
  }
}