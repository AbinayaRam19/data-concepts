package abiP

class IntIterator(to: Int) extends Iterator[Int] {
  private var current = 0

  override def hasNext: Boolean = current < to

  override def next(): Int = {
    if (hasNext) {

      println("before:" + current)
      val t = current
      current += 1
      println("after: " + current)
      t
    } else 0
  }
}