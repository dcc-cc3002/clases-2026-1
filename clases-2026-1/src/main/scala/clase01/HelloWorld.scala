import scala.io.StdIn.readLine

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello World!")
  }

}

@main def main2() = {
  println("Please enter your name and your age:")
  val name: String = readLine()
  val age: Int = readLine().toInt
  println(s"Hello $age, your age is $name!")
}
