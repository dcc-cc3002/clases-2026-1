package clase17

class InvalidTransitionException(action: String, state: String)
    extends Exception(
      s"Invalid transition: cannot '$action' when in state '$state'"
    )

class OutOfFuelException extends Exception()

trait State:
  def play(controller: Controller): Unit
  def start(controller: Controller): Unit
  def end(controller: Controller): Unit
  // WARNING: SOLO PARA TESTING!!!
  def isStart(): Boolean
  def isPTurn(): Boolean
  def isETurn(): Boolean

abstract class AbstractState(name: String) extends State:
  private def error(action: String) =
    throw new InvalidTransitionException(action, name)
  def play(controller: Controller): Unit = error("play")
  def start(controller: Controller): Unit = error("start")
  def end(controller: Controller): Unit = error("end")

  def isStart() = false
  def isPTurn() = false
  def isETurn() = false

  def checkSteps(steps: Int) =
    if (steps <= 0) throw new OutOfFuelException()

class StartState(steps: Int) extends AbstractState("START"):
  override def play(controller: Controller) = ()
  override def start(controller: Controller) =
    checkSteps(steps)
    controller.setState(new PTurnState(steps - 1))
  override def isStart() = true

class PTurnState(steps: Int) extends AbstractState("P_TURN"):
  override def play(controller: Controller): Unit =
    checkSteps(steps)
    controller.setState(new ETurnState(steps - 1))
  override def end(controller: Controller): Unit =
    checkSteps(steps)
    controller.setState(new StartState(steps - 1))
  override def isPTurn() = true

class ETurnState(steps: Int) extends AbstractState("E_TURN"):
  override def play(controller: Controller): Unit =
    checkSteps(steps)
    controller.setState(new PTurnState(steps - 1))
  override def end(controller: Controller): Unit =
    checkSteps(steps)
    controller.setState(new StartState(steps - 1))
  override def isETurn() = true
