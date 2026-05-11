package clase16

object Ejercicio2 {
  trait CanBike {
    def bike(): Unit
  }
  trait CanRun {
    def run(): Unit
  }
  trait CanSwim {
    def swim(): Unit
  }
  def performActions[T <: CanBike & CanRun](l: List[T]): Unit = {
    l.foreach({ (x: T) =>
      x.bike()
      x.run()
    })

    for (x <- l) {
      x.bike()
      x.run()
    }
  }
  trait Duck extends CanRun with CanSwim

  val ducks: List[Duck] = ???
  //performActions(ducks)
}
