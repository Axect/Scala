import scala.collection.immutable.Vector.empty

object Tutorial {
  def main(args: Array[String]): Unit = {
    println(vector)
    println(vector2)
    println(vector3)
    println(vector4)

    println(v)
    println(v2)
  }

  val vector = empty
  val vector2 = vector :+ 5
  val vector3 = vector2 :+ 10 :+ 20 // append
  val vector4 = 100 +: vector3 // prepend

  val v = empty
  val v2 = v ++ List(10,20,30)
}
