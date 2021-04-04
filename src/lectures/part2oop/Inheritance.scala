package lectures.part2oop

object Inheritance extends App {

  class Animal {
    val creatureType = "wild"

    def eat: String = "nomnomnom"
  }

  class Cat extends Animal

  val cat = new Cat
  println(cat.eat)

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  class Dog(override val creatureType: String) extends Animal {
    override def eat = {
      super.eat
    }
  }

  val dog = new Dog("K9")
  println(dog.eat)

}
