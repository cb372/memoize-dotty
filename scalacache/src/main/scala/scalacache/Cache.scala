package scalacache

class Cache[V] {

  private val underlying = scala.collection.mutable.HashMap.empty[String, V]

  def get(key: String): Option[V] = underlying.get(key)

  def put(key: String, value: V): Unit = underlying.put(key, value)

}
