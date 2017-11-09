object SpeedOfMap {
  def main(args: Array[String]): Unit = {
    val t = System.nanoTime
    val v = (1 to 1e6.toInt).map(i => i*i)
    val elapsed = (System.nanoTime - t) / 1e9d
    println(elapsed)
  }
}
