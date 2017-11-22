object array {
  def main(args: Array[String]): Unit = {
    for (i <- 0 to 2) {
      print(strings(i))
    }
  }

  val strings = new Array[String](3)
  strings.update(0, "Hello")
  strings.update(1, ", ")
  strings.update(2, "world!\n")
}
