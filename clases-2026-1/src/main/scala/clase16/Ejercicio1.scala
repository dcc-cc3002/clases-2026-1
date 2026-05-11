package clase16

import scala.collection.mutable.ListBuffer

object Ejercicio1 {

  class Animal
  class Pet extends Animal

  class Container[T >: Pet <: Animal] {
    private val elements: ListBuffer[T] = ListBuffer.empty[T]
    def addElement(element: T): Unit =
      elements += element
    def getElements(): List[T] = elements.toList
  }
}
