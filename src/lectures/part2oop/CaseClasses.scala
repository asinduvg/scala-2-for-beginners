package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)

  println(jim.age)

  // 2. sensible toString
  println(jim)

  // 3. equals and hashcode are implemented out of the box
  val jim2 = new Person("Jim", 34)

  println(jim == jim2)

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 32)

  println(jim3)

  // 5. CCs have companion objects
  val thePerson = Person

  val mary = Person("Mary", 23)
  println(mary)

  // 6. CCs are serializable
  // Akka framework

  // 7. CCs have extractor patterns = CCs can be used in pattern matching

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  // EXPAND MY LIST


}
