package clase16

object Ejercicio3 {

  trait Vehicle
  trait Car extends Vehicle
  trait Bicycle extends Vehicle

  class ShowRoom[+T <: Vehicle](v: T) {
    def show(): T = v
  }

  class RepairShop[-T <: Vehicle] {
    def repair(v: T): Unit = ???
  }

  class Garage[T <: Vehicle] {
    def store(v: T): Unit = ???
    def get(): T = ???
  }

  class Par[T, S](val first: T, val second: S) {
    def swap(): Par[S, T] = new Par(second, first)
  }

  def foo[S](x: S): S = x
  def bar[T, S](x: (T, S)): (S, T) = ???
  def baz[A, B](x: A => B, y: List[A]): List[B] = ???

}
