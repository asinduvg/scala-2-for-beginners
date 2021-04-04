package lectures.part2oop

object Generics extends App {

  class MyList[A] {

  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  class Animal

  class Dog extends Animal

  class Cat extends Animal

  class CovariantList[+A]

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  class InvariantList[A]

  val invariantListAnimal: InvariantList[Animal] = new InvariantList[Animal]

  class ContravariantList[-A]

  val contravariantListAnimal: ContravariantList[Cat] = new ContravariantList[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)

  val cage = new Cage[Dog](new Dog)

  class Car


}
