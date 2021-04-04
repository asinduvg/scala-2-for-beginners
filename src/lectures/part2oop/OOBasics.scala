package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 24)
  //  println(person.greet("Asindu"))
  //  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
  //  println(novel.authorAge())
  //  println(novel.isWrittenBy(author))

  val counter = new Counter
  counter.increment

}

class Person(name: String, val age: Int) {
  def greet(name: String): Unit = println(s"${this.name} says, Hi, $name")

  def greet(): Unit = println(s"$name says, Hi")

}

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName(): String = this.firstName + " " + this.surname
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge(): Int = this.yearOfRelease - author.year

  def isWrittenBy(anAuthor: Writer): Boolean = anAuthor == author

  def copy(yearOfRelease: Int): Novel = new Novel(this.name, yearOfRelease, this.author)

}

class Counter(val count: Int = 0) {

  def increment(): Counter = {
    println("incrementing")
    println(count)
    new Counter(count + 1)
  }

  def decrement(): Counter = {
    println("decrementing")
    new Counter(count - 1)
  }

  def increment(amount: Int): Counter = {
    if (amount <= 0) this
    else increment().increment(amount - 1)
  }

  def decrement(amount: Int): Counter = {
    if (amount <= 0) this
    else decrement().decrement(amount - 1)
  }
}

