package abiP

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, spark_partition_id, udf}

object ObjDeclaration {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("trst").master("local[*]").getOrCreate()

    val list = Seq((1, 3), (3, 4), (5, 6))

    import spark.implicits._

    var rdd = spark.sparkContext.parallelize(list)

    var aa = rdd.map(x => (x._1, x._2))
    var dff = aa.toDF()
    dff.show()


    var largestNumber = udf((x: Int, y: Int) => if (x > y) x else y)

    spark.udf.register("largre", largestNumber)


    println("ouput partitions "+dff.rdd.getNumPartitions)

    dff.withColumn("largest", largestNumber(col("_1"), col("_2")))
      .withColumn("Partition", spark_partition_id())
    .show()


  }
}