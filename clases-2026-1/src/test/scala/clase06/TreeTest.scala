package clase06
import munit.*

class TreeTest extends FunSuite {
  val t1: Tree =
    new Node(
      45,
      new Node(34, new Leaf(13), new Leaf(25)),
      new Node(4, new NullTree(), new NullTree())
    )
  test("suma de un arbol") {
    assertEquals(t1.sum(), 121)
  }
  test("minimo de un arbol") {
    assertEquals(t1.min(), 4)
  }
  test("maximo de un arbol") {
    assertEquals(t1.max(), 45)
  }
}
