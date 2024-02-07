package abiP

import SparkWithEMR.SparkSessionWrapper
import org.apache.spark.sql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{lit, rand}
object  Salting extends App with SparkSessionWrapper {
import spark.sqlContext.implicits._

  val conf = spark.sparkContext.getConf

  conf.set("log4j.rootCategory","ERROR")

  // Original dataset with skewed keys
  val data = Seq(
    ("A", 100),
    ("B", 150),
    ("A", 120),
    ("C", 200),
    ("C", 400)
    // ... more data
  )

  val originalDF = spark.createDataFrame(data).toDF("key", "value")

  println("original df "+originalDF.show())

  // Apply salting by adding a random number (0 to 9) to the key
  val saltedDF = originalDF.withColumn("salt", (rand() * 10).cast("int"))

  println("saltedDF "+saltedDF.show())
  // Combine key and salt for the new partition key
  val partitionedDF = saltedDF.withColumn("partition_key", sql.functions.concat($"key", lit("_"), $"salt"))

  println("partitionedDF "+partitionedDF.show())
  // Perform operations on the salted and partitioned data
  val result = partitionedDF.groupBy("partition_key").agg(sql.functions.sum("value").alias("total_value"))

  println("result")
  result.show()
}