object testex {
  def main(Args: Array[String]): Unit = {
    val x = Stream(1,2,3,4,5)
    val h1 = x.take(3)
    val h2 = x.drop(3)
    println(h1, h2)
    println(h1.toList, h2.toList)
  }
}
