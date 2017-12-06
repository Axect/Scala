object TakeNDrop {
  def main(args: Array[String]): Unit = {
    val x = Stream(1,2,3,4,5)
    val xt = x.take(3)
    val xd = x.drop(3)
    println(xt, xd)
    println(xt.toList, xd.toList)
  }
}
