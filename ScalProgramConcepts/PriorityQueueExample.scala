package abiP

import scala.collection.mutable

object PriorityQueueExample extends App {
  // Creating a mutable PriorityQueue of integers
  val priorityQueue = mutable.PriorityQueue(5, 3, 7, 1, 9)

  // Enqueueing elements
  priorityQueue.enqueue(4, 2, 8)

  println("Elements in the PriorityQueue begin:")
  priorityQueue.foreach(println)

  // Dequeueing elements (removing and returning the highest-priority element)
  val highestPriorityElement = priorityQueue.dequeue()
  println(s"Highest Priority Element: $highestPriorityElement")

  // Peek at the highest-priority element without removing it
  val peekedElement = priorityQueue.head
  println(s"Peeked Element: $peekedElement")

  // Iterate through the elements (not guaranteed to be in priority order after dequeue operations)
  println("Elements in the PriorityQueue:")
  priorityQueue.foreach(println)
}
