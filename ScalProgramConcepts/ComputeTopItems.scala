package abiP

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

import scala.collection.mutable
import scala.collection.mutable.PriorityQueue

object ComputeTopItems extends App {


  // Assuming you have a SparkContext spark and an RDD named dataRDD containing the billion entries

  val spark = SparkSession.builder().appName("trst").master("local[*]").getOrCreate()
  val N =10
  val dataRDD = spark.sparkContext.parallelize(Range(200,10000))
  // Step 1: Split into partitions
  val partitionedRDD: RDD[Int] = dataRDD.repartition(10)

  // Step 2: Compute top N within each partition
  val topNPerPartitionRDD: RDD[PriorityQueue[Double]] = partitionedRDD.mapPartitions(computeTopN)

  def computeTopN(iterator: Iterator[Int]): Iterator[PriorityQueue[Double]] = {
    val pq: PriorityQueue[Double] = new PriorityQueue[Double]()(Ordering[Double].reverse)

    iterator.foreach { item =>
      pq.enqueue(item.toDouble)
      if (pq.length > N) {
        pq.dequeue()
      }
    }

    Iterator(pq)
  }
  // Step 3: Merge results from all partitions
  val mergedPQ: PriorityQueue[Double] = topNPerPartitionRDD.reduce(mergePriorityQueues)

  def mergePriorityQueues(pq1: mutable.PriorityQueue[Double], pq2: PriorityQueue[Double]): PriorityQueue[Double] = {
    val mergedPQ: PriorityQueue[Double] = new PriorityQueue[Double]()(Ordering[Double].reverse)

    pq1.foreach { item =>
      mergedPQ.enqueue(item)
      if (mergedPQ.length > N) {
        mergedPQ.dequeue()
      }
    }

    pq2.foreach { item =>
      mergedPQ.enqueue(item)
      if (mergedPQ.length > N) {
        mergedPQ.dequeue()
      }
    }

    mergedPQ
  }

  // Step 4: Compute the average
  val (totalSum, totalCount) = mergedPQ.foldLeft((0.0, 0)) { case ((sum, count), item) =>
    (sum + item, count + 1)
  }

  val average: Double = totalSum / totalCount
  println("average "+average)
}
