package abiP

import SparkWithEMR.SparkSessionWrapper
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object ParquetWriter extends SparkSessionWrapper{
  def main(args: Array[String]): Unit = {
    // Create a Spark session


    import spark.implicits._
    // Create a sample DataFrame
    val data = Seq(
      ("Alice", 15, "New York"),
      ("Bob", 10, "San Francisparko"),
      ("Charlie", 22, "Seattle")
    )

    val sparkschema = new StructType()
      .add(StructField("Name", StringType, nullable = true))
      .add(StructField("Age", IntegerType, nullable = true))
      .add(StructField("City", StringType, nullable = true))

    val df: DataFrame = spark.createDataFrame(data).toDF("Name", "Age", "City")


    // Write the DataFrame to a Parquet file
    df.write.partitionBy("Name").parquet("samplePartitionBy.parquet")


    val parquetFileDF = spark.read.parquet("singleSample.parquet")

    // Parquet files can also be used to create a temporary view and then used in SQL statements
    parquetFileDF.createOrReplaceTempView("parquetFile")
    val namesDF = spark.sql("SELECT name FROM parquetFile WHERE Age BETWEEN 13 AND 19")
    namesDF.map(attributes => "Name: " + attributes(0)).show()

  }
}