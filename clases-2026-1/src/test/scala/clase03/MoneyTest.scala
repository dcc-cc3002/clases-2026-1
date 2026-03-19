package clase03

class MoneyTest extends munit.FunSuite:
  var _12clp: Money = null
  var _14clp: Money = null

  override def beforeEach(context: BeforeEach): Unit =
    _12clp = new Money(12, "CLP")
    _14clp = new Money(14, "CLP")

  test("Dos objetos son iguales si son la misma direccion de memoria") {
    assertEquals(_12clp, _12clp)
  }
  test("Dos objetos no son iguales si son distintas direcciones de memoria") {
    assertNotEquals(_12clp, _14clp)
  }
  test("Igualdad de dos pesos chilenos despues de la suma") {
    val result = _12clp.add(new Money(2, "CLP"))
    assertEquals(result, _14clp) // assert(result.equals(_14clp))
  }
