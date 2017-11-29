package Basic

import scala.reflect.ClassTag

package object DataStructure {
  // Basic Type Aliases
  type XY = Tuple2[Double, Double]
  def XY(x: Double, y:Double) = Tuple2[Double, Double](x,y)

  type XYTSeries = Array[XY]
  def XYTSeries(x: XY*) = Array[XY](x: _*)

  type DVector[T] = Array[T]
  def DVector[T:ClassTag](x: T*) = Array[T](x: _*)

  type DMatrix[T] = Array[Array[T]]
  def DMatrix[T:ClassTag](x: DVector[T]*) = Array[Array[T]](x: _*)

  type DblVector = DVector[Double]
  def DblVector(x: Double*) = DVector[Double](x: _*)

  type DblMatrix = DMatrix[Double]
  def DblMatrix(x: DblVector*) = DMatrix[Double](x: _*)

  def DVectorString[T:ClassTag](x: DVector[T]): String = s"DVector(${x.mkString(",")})"
  def DMatrixString[T:ClassTag](m: DMatrix[T]): String = s"DMatrix(${m.map(x => DVectorString(x)).mkString("\n\t\t")})"

  def printVector[T:ClassTag](x: DVector[T]) = println(DVectorString(x))
  def printMatrix[T:ClassTag](m: DMatrix[T]) = println(DMatrixString(m))

  // Implicit Transforms
  implicit def int2Double(n: Int): Double = n.toDouble
  implicit def vector2DblVector[T <% Double](x: DVector[T]): DblVector = x.map(elem => elem.toDouble)
  implicit def double2DblVector(x: Double): DblVector = DblVector(x)
}
