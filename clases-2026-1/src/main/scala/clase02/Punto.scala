package clase02

trait Movible:
  def moveBy(deltaX: Int, deltaY: Int): Unit

class Punto(var x: Int, var y: Int) extends Movible:
  def moveBy(deltaX: Int, deltaY: Int): Unit =
    x += deltaX
    y += deltaY

class Rectangulo(var origen: Punto, var alto: Int, var ancho: Int)
    extends Movible:
  def moveBy(deltaX: Int, deltaY: Int): Unit =
    // delegar!
    origen.moveBy(deltaX, deltaY)
  def getArea: Int = alto * ancho

@main def mainPunto(): Unit =
  val p: Punto = new Punto(1, 1)
  p.moveBy(2, 2)
  println(s"Punto: (${p.x}, ${p.y})")

  val r: Rectangulo = new Rectangulo(new Punto(0, 0), 10, 20)
  println(s"Area: ${r.getArea}")
  r.moveBy(5, 5)
  println(s"Rectangulo origen: (${r.origen.x}, ${r.origen.y})")

  val list: List[Movible] = List(p, r)
  for (e <- list) do e.moveBy(10, 10)
