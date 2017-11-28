package Basic

import scala.reflect.ClassTag

package object DataStructure {
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
}
