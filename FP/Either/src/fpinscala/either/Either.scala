package fpinscala.either

sealed trait Either[+E, +A] {

}
case class Left[+E](value: E) extends Either[E, Nothing] // Fail
case class Right[+A](value: A) extends Either[Nothing, A] // Success