// Import Test Successful! => Just use real Stream
// import fpinscala.Stream._
object test {
  def main(Args: Array[String]): Unit = {
    val x = Stream(1,2,3,4,5,6,7,8,9,10)
    val xTake = x.take(5)
    val xDrop = x.drop(5)
    val y = x.takeWhile(x => x < 6)

    println(s"${xTake}, ${xDrop}")
    println(s"${xTake.toList}, ${xDrop.toList}")
    println(y)
    println(y.toList)
    println(exist(x)(x => x%2 == 0))
    println(x.foldRight(false)((a, b) => a % 2 == 0 || b))
    println(fibs(0).take(10).toList)
  }

  def exist[A](x: Stream[A])(p: A => Boolean): Boolean = x match {
    case h #:: t => p(h) || exist(t)(p)
    case _ => false
  }

  def fibs(n: Int): Stream[Int] = fiboGen(n) #:: fibs(n+1)

  def fiboGen(n: Int): Int = n match {
    case _ if n < 0 => 0
    case 0 => 0
    case 1 => 1
    case n if n > 1 => fiboGen(n-1) + fiboGen(n-2)
  }
 }
