package abiP

import org.apache.spark.Partitioner
import org.apache.spark.sql.SparkSession



object Partitioner extends App {


  val spark = SparkSession.builder().appName("trst").master("local[*]").getOrCreate()

  val rdd1 = spark.sparkContext.parallelize(List(1, 2, 3, 4)).map(x => (x, x+1))

  import spark.implicits._
 val df1 =  rdd1.toDF().show()

  spark.createDataset(rdd1).show()

  val equallyDistributedPartitionTwo = rdd1.partitionBy(new EqualDistributionPartitioner(5))
}

class EqualDistributionPartitioner(numberOfPartitions: Int) extends Partitioner {
  override def numPartitions: Int = numberOfPartitions

  override def getPartition(key: Any): Int = {
    (key.asInstanceOf[Long] % numberOfPartitions).toInt
  }
}




