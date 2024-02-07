package abiP

import org.apache.spark.sql.{Row, SparkSession}

object createDF extends App{

  val spark = SparkSession.builder
    .appName("createDF")
    .master("local[*]")
    .getOrCreate()

  import org.apache.spark.sql.types._

  val data = Seq(
    Row(8, "bat"),
    Row(64, "mouse"),
    Row(-27, "horse")
  )

  val sparkschema = StructType(
    List(
      StructField("number", IntegerType, nullable = true),
      StructField("word", StringType, nullable = true)
    )
  )

  val df = spark.createDataFrame(
    spark.sparkContext.parallelize(data),
    sparkschema
  )
}
