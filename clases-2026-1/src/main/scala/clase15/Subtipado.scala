package clase15

object Subtipado {
  class A
  class B extends A
  class C extends B
  def foo(f: (A => B) => C): Unit = ???
  def bar(g: A => B): C = ???

  /*
  C <: A      B <: D
  -----------------
  A => B <: C => D

   */

  // foo(bar)
  // foo: ((A => B) => C) => Unit
  // bar: (A => B) => C
  // tenemos que chequear que el tipo de bar sea subtipo del dominio del tipo de foo
  /*
  A <: A ✅      B <: B ✅
  --------------------
  (A => B) <: (A => B) ✅     C <: C ✅
  ----------------------------------
    (A => B) => C <: (A => B) => C
   */

  def baz(f: B => A): C = ???

  // foo(baz)
  /*
  baz: (B => A) => C

  B <: A ✅    B <: A ✅
  ---------------------
  (A => B) <: (B => A) ✅      C <: C ✅
  ----------------------------------
  (B => A) => C <: (A => B) => C ✅
  no typechequea

   */

  def bash(f: Any => B): C = ???

  // foo(bash)
  /*
  baz: (B => A) => C

  Any <: A ❌    B <: A
  ---------------------
  (A => B) <: (Any => A) ❌      C <: C ✅
  ----------------------------------
  (Any => A) => C <: (A => B) => C ❌
  no typechequea
   */



    
  trait Tipo:
    def isSubtype(other: Tipo): Boolean
    def isTipoFuncionSubType(f: TipoFuncion): Boolean
    def isTipoBoolSubType(f: TipoBool): Boolean
    def isTipoAnySubType(f: TipoAny): Boolean

  abstract class TipoAbstracto extends Tipo:
    def isTipoFuncionSubType(f: TipoFuncion): Boolean = false
    def isTipoBoolSubType(f: TipoBool): Boolean = false
    def isTipoAnySubType(f: TipoAny): Boolean = false

  class TipoBool extends TipoAbstracto:
    override def isSubtype(other: Tipo): Boolean = other.isTipoBoolSubType(this)
    override def isTipoBoolSubType(f: TipoBool): Boolean = true

  class TipoAny extends TipoAbstracto:
    override def isSubtype(other: Tipo): Boolean = other.isTipoAnySubType(this)
    override def isTipoFuncionSubType(f: TipoFuncion): Boolean = true
    override def isTipoBoolSubType(f: TipoBool): Boolean = true
    override def isTipoAnySubType(f: TipoAny): Boolean = true

  class TipoFuncion(val dom: Tipo, val cod: Tipo) extends TipoAbstracto:
    override def isSubtype(other: Tipo): Boolean =
      other.isTipoFuncionSubType(this)
    override def isTipoFuncionSubType(f: TipoFuncion): Boolean =
      dom.isSubtype(f.dom) && f.cod.isSubtype(cod)

  val any = new TipoAny()
  val bool = new TipoBool()
  val f1 = new TipoFuncion(any, bool)
  val f2 = new TipoFuncion(bool, any)

  def main(args: Array[String]): Unit = {
    println(any.isSubtype(any))
    println(bool.isSubtype(bool))
    println(f1.isSubtype(f1)) // true
    println(f1.isSubtype(any)) // true
    println(f1.isSubtype(f2)) // true
    println(f2.isSubtype(f1)) // false

  }
}

object FP {
  trait Tipo
  case class TipoBool()
  case class TipoAny()
  case class TipoFuncion(dom: Tipo, cod: Tipo)

  def isSubtype(t1: Tipo, t2: Tipo): Boolean =
    (t1, t2) match {
      case (_, TipoAny()) => true
      case (TipoFuncion(dom1, cod1), TipoFuncion(dom2, cod2)) =>
        isSubtype(dom2, dom1) && isSubtype(cod1, cod2)
      case _ => t1 == t2
    }

}
