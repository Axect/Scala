import ADT._

object Size {
  def main(args: Array[String]): Unit = {
    println(size(tr))
  }

  def size[A](tr: Tree[A]): Int = tr match {
    case Leaf(_) => 1
    case Branch(lx, rx) => 1 + size(lx) + size(rx)
    case Nil => 0
  }

  val tr1 = Branch(Leaf(1), Leaf(2))
  val tr2 = Branch(Leaf(3), Leaf(4))
  val tr = Branch(tr1, tr2)
}
