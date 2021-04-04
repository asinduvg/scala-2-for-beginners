package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(nickName: String): Person = new Person(s"${name} (${nickName})", favMovie)

    def unary_! : String = s"${this.name} what the heck"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favMovie"

    def apply(n: Int): String = s"$name watched $favMovie $n times"

    def unary_+ : Person = new Person(name, favMovie, age + 1)

    def learns(str: String): String = s"${name} learns ${str}"

    def learnsScala: String = this learns "Scala"

  }

  val mary = new Person("Mary", "Inception")
  val john = new Person("John", "FaF")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // infix notation

  println(mary + john)
  println(!mary)
  println(mary.unary_!)

  println(mary isAlive)

  println(mary())

  println((mary + "the rockstar") ())

  println((+mary).age)

  println(mary learnsScala)

  println(mary(2))

}
