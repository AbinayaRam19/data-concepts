package abiP

import org.apache.spark.sql.functions.{col, count, first, spark_partition_id}

object DFPivot extends App {


  import org.apache.spark.sql.SparkSession

  // Create SparkSession
  val spark: SparkSession = SparkSession.builder()
    .master("local[2]").appName("SparkByExamples.com")
    .getOrCreate()

  // Create a sample DataFrame

  import spark.implicits._

  val data = Seq((1, "A", 10), (1, "B", 20), (2, "A", 30), (2, "B", 40),(3,"C",40))
  val df = data.toDF("id", "col1", "col2")

  df
    .withColumn("partition_id", spark_partition_id())
    .groupBy("partition_id")
    .agg(count("*").alias("count"))
    .orderBy(col("count"))
    .show()



  //////////pivot


  // Pivot the DataFrame to transpose it

  val transposedDf = df.groupBy("id").pivot("col1")
    .agg(first("col2"))

  // Show the transposed DataFrame
  transposedDf.show()


  // Group by id and pivot the DataFrame
//  val transposedDf1 = df.groupBy("id")
//    .agg(collect_list(struct($"col1", $"col2")).as("cols"))
//    .select($"id", explode($"cols"))
//    .groupBy("col1")
//    .pivot("id")
//    .agg(first("col2"))
//
//  // Show the transposed DataFrame
//  transposedDf1.show()





}
