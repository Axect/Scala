import ADT._

object Tree {
  def main(args: Array[String]): Unit = {
    println(size(tr))
    println(maximum(tr))
    println(depth(tr_wrap))
    println(map(tr)(x => x + 1))
  }

  def size[A](tr: Tree[A]): Int = tr match {
    case Leaf(_) => 1
    case Branch(lx, rx) => 1 + size(lx) + size(rx)
    case Nil => 0
  }

  def maximum(tr: Tree[Int]): Int = tr match {
    case Branch(lx, rx) => maximum(lx) max maximum(rx)
    case Leaf(x) => x
    case Nil => 0
  }

  def depth[A](tr: Tree[A]): Int = tr match {
    case Nil => 0
    case Branch(lx, rx) => 1 + (depth(lx) max depth(rx))
    case Leaf(_) => 1
  }

  def map[A, B](tr: Tree[A])(f: A => B): Tree[B] = tr match {
    case Nil => Nil
    case Branch(lx, rx) => Branch(map(lx)(f), map(rx)(f))
    case Leaf(x) => Leaf(f(x))
  }

  val tr1 = Branch(Leaf(1), Leaf(2))
  val tr2 = Branch(Leaf(3), Leaf(4))
  val tr = Branch(tr1, tr2)
  val tr_wrap = Branch(tr, Leaf(5))
}
