package scalacache

import scala.quoted._
import scala.tasty._

object Memoize {

  inline def memoize[V](f: => V) given (cache: Cache[V]): V =
    ${ MemoizeMacro.memoize('f, 'cache) }

}

object MemoizeMacro {
  implicit val toolbox: scala.quoted.Toolbox = scala.quoted.Toolbox.make(getClass.getClassLoader)

  def memoize[V: Type](f: Expr[V], cache: Expr[Cache[V]]) given (qctx: QuoteContext): Expr[V] = {
    '{
      val key = "TODO generate key"
      $cache.get(key) match {
        case Some(value) => value
        case None =>
          val result = $f
          $cache.put(key, result)
          result
      }
    }
  }


}
