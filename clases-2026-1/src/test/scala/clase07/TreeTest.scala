package clase07

import munit.*

class TreeTest extends FunSuite {
  val t1: Tree =
    new Node(
      45,
      new Node(34, new Leaf(13), new Leaf(25)),
      new Node(4, new NullTree(), new NullTree())
    )
  val t2 = new Leaf(10)
  test("suma de un arbol") {
    assertEquals(t1.sum(), 121)
  }
  test("minimo de un arbol") {
    assertEquals(t1.min(), 4)
  }
  test("maximo de un arbol") {
    assertEquals(t1.max(), 45)
  }

  test("comparar dos arboles") {
    assertEquals(t1.compareTo(t2), 1)
    assertEquals(t1.compareTo(t1), 0)
    assertEquals(t2.compareTo(t1), -1)
    val sortedList = List(t1, t2).sorted
    assertEquals(sortedList.head, t2)

  }
}
