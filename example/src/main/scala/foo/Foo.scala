package foo

import scalacache._

object Foo {

  given as Cache[Int] = new Cache[Int]

  def complexCalculation(a: Int, b: Int): Int = Memoize.memoize {
    println("Evaluating function body!")
    a + b
  }

}
