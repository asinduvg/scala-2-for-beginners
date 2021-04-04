package lectures.part2oop

object Objects {

  object Person {
    val N_EYES = 2

    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person) = new Person("Bobbie")
  }

  class Person(val name: String) {

  }

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)
    println(Person(new Person("Asindu"), new Person("Chamika")).name)
  }

}
