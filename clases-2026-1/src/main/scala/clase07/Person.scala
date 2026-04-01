package clase07

abstract class AbstractPerson(
    val name: String,
    val age: Int,
    val email: String
):
  println("AbstractPerson.body")

  def this(name: String, age: Int) =
    this(name, age, "")
    println("AbstractPerson.alt")

  def foo(): Unit

abstract class Student(name: String, age: Int, val studentId: String)
    extends AbstractPerson(name, age):

  def this(name: String, age: Int) =
    this(name, age, "")
    foo()
    println("Student.alt")

  println("Student.body")

class PhDStudent(name: String, age: Int, val researchArea: String)
    extends Student(name, age):
  println("PhDStudent.body")

  def foo() = println("PhDStudent.foo")

object Main {
  def main(args: Array[String]): Unit = {
    val s1 = new PhDStudent("Alice", 30, "AI")
    println(s"Student: ${s1.name}, ${s1.age}, ${s1.studentId}")
  }
}

/*
- AbstractPerson.body
- AbstractPerson.alt
- Student.body
- PhDStudent.foo
- Student.alt
- PhDStudent.body
 */
