package exercise

import exercise.ListTest.EvenPredicate
import lectures.part2oop.Generics.MyList

abstract class MyList[+A] {

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  def filter(predicate: MyPredicate[A]): MyList[A]

}

object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  override def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(this.head)) new Cons[A](h, this.tail.filter(predicate))
    else this.tail.filter(predicate)
  }

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] = ???

}

trait MyPredicate[-T] {
  def test(value: T): Boolean
}

trait MyTransformer[-A, B]

class EvenPredicate extends MyPredicate[Int] {
  override def test(n: Int): Boolean = n % 2 == 0
}


object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, Empty)))
  val listOfStrings: MyList[String] = new Cons[String]("Asindu", new Cons[String]("Chamika", new Cons[String]("VG", Empty)))

  //  println(listOfIntegers)
  //  println(listOfStrings)

  val evenPredicate = new EvenPredicate
  println(evenPredicate.test(23))

}


