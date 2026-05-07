package clase07

trait Loggable:
  def tag: String
  println(s"[LOG] Registrando: $tag")

abstract class Vehicle(val brand: String) extends Loggable:
  println(s"[Vehicle] Creando vehiculo: $brand")

  def describe(): String

class Car(brand: String,  val model: String,  val year: Int) extends Vehicle(brand):

  def tag: String = s"$brand-$model"

  println(s"[Car] Inicializando: $brand $model $year")

  def this(brand: String, model: String) =
    this(brand, model, 2026)
    println(s"[Car.this(2)] Año por defecto asignado")

  def this(brand: String) =
    this(brand, "Generico")
    println(s"[Car.this(1)] Modelo generico asignado")

  def describe(): String = s"$brand $model ($year)"

  println(s"[Car] Fin init: ${describe()}")

@main def run(): Unit =
  println("=== Creando auto1 ===")
  val auto1 = new Car("Toyota", "Corolla", 2024)
  println()
  println("=== Creando auto2 ===")
  val auto2 = new Car("Ford", "Focus")
  println()
  println("=== Creando auto3 ===")
  val auto3 = new Car("Nissan")
  println()
  println(auto1.describe())
  println(auto2.describe())
  println(auto3.describe())