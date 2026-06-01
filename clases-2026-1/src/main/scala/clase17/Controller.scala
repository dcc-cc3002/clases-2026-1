package clase17

import scala.util.Success

class Controller {
  // aca va nuestro estado
  val initialState = new StartState(10)
  private var state: State = initialState
  def setState(newState: State): Unit =
    state = newState
  def reset() = state = initialState
  // estas son las acciones
  // lo que hacemos aca es delegar
  def play(): Either[String, Unit] =
    safeRun(state.play(this))
  def start(): Either[String, Unit] =
    safeRun(state.start(this))
  def end(): Either[String, Unit] =
    safeRun(state.end(this))

  def safeRun(body: => Unit): Either[String, Unit] =
    try
      // ejecutar el body ahora!
      body
      Right(())
    catch case e => Left(e.toString())

  // WARNING: SOLO PARA TESTING!!!
  def isStart() = state.isStart()
  def isPTurn() = state.isPTurn()
  def isETurn() = state.isETurn()
}
