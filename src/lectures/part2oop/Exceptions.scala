package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length)
  // this will crash with a NPE

  // 1. throwing exceptions

  //  val aWeirdValue = throw new NullPointerException

  // throwable classes extend throwable class
  // exception and error are two major throwable subtypes

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No INT for you!!")
    else 42
  }

  try {
    //    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught a Runtime Exception")
  } finally {
    // code that will execute no matter what
    // optional
    // does not influence the return type of the expression
    // use finally only for side effects
    println("finally")
  }

  // 3. how to define own exceptions
  class MyException extends Exception

  //  val exception = new MyException

  //  throw exception

  /*
  * 1. Crash your program with an OutOfMemory Error
  * 2. Crash with SOError
  * 3. Pocket Calculator
  *     - add(x, y)
  *     - sub(x, y)
  *     - multiply(x, y)
  *     - div(x, y)
  *
  *   Throw
  *     - Overflow Exception if(x, y) exceeds INT.MAX_VALUE
  *     - Underflow Exception if(x, y) exceeds INT.MIN_VALUE
  *     - MathCalculationException for division by 0
  *
  * */

  def massiveNumber(number: Int): Double = Math.pow(number, 1000000)

  println(massiveNumber(10))

  //  def infiniteLoop(x: Int): AnyVal = infiniteLoop(x)

  //  infiniteLoop(23)

}
