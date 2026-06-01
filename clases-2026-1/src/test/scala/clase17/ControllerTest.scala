package clase17

import munit.FunSuite

class ControllerTest extends FunSuite {
  val controller = new Controller()

  override def beforeEach(context: BeforeEach): Unit = {
    controller.reset()
  }
  test("el estado inicial de un controlador es START") {
    assert(controller.isStart())
  }
  test("si ejecutamos la accion start, deberiamos cambiar de estado a P_TURN") {
    controller.start()
    assert(controller.isPTurn())
  }
  test(
    "si estamos en P_TURN y accion=play entonces el nuevo estado es E_TURN"
  ) {
    controller.start()
    controller.play()
    assert(controller.isETurn())
  }
  test("si estamos en E_TURN y accion=play, entonces volvemos  a P_TURN") {
    controller.start()
    controller.play()
    controller.play()
    assert(controller.isPTurn())
  }
  test("si se nos acaban los pasos, deberiamos arrojar un error") {
    controller.start()
    controller.play()
    controller.play()
    controller.play()
    controller.play()
    controller.play()
    controller.play()
    controller.play()
    controller.play()
    controller.play()

    assertEquals(controller.play(), Left("clase17.OutOfFuelException"))
  }
}
