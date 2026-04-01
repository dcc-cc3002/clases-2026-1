package clase06

object Zoo {

  trait Animal:
    def darComida(): Unit

  class Dog extends Animal:
    def darComida(): Unit =
      println("Ñam ñam ñam")

  def alimentar(a: Animal) = {
    a.darComida()
  }
  val dogo: Dog = new Dog()

  alimentar(dogo)

}
