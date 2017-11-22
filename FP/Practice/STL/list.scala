object TestList {
  def main(args: Array[String]): Unit = {
    println(temp)
    println(temp.map(x => x + 2))
    println(temp.foldLeft(0)(_+_))
    println(temp.foldLeft(1)(_*_))
    println(temp.flatMap(x => List(x-1, x+1)))
  }

  val temp = List(1,2,3)
}
