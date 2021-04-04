package lectures.part2oop

object AbstractDataTypes extends App {

  abstract class Animal() {
    val creatureType: String

    def eat(): Unit
  }

  class Dog extends Animal {
    override val creatureType = "Canine"

    override def eat(): Unit = "crunch crunch"
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "croc"

    override def eat(): Unit = println("nomnom")

    override def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val croc = new Crocodile
  croc.eat()
  croc.eat(new Dog)

}
