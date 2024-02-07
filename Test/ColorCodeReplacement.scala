package Test

import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, SparkSession}

object ColorCodeReplacement {
  def main(args: Array[String]): Unit = {
    // Step 1: Create Spark Session
    val spark = SparkSession.builder
      .appName("ColorCodeReplacement")
      .master("local[*]")
      .getOrCreate()
    // Step 2: Sample DataFrame
    val data = Seq(
      (1, Seq("red", "blue", "black")),
      (2, Seq("purple", "green"))
    )
    

    val df: DataFrame = spark.createDataFrame(data).toDF("id", "color")
      .withColumn("color", col("color").cast(ArrayType(StringType)))

    // Step 3: Define UDF to replace colors with color codes
    val colorCodeMap = Map(
      "red" -> "#FF0000",
      "blue" -> "#0000FF",
      "black" -> "#000000",
      "purple" -> "#800080",
      "green" -> "#008000"
    )

    val replaceColorUDF = udf((colors:Seq[String]) => {
      colors.map(color => colorCodeMap.getOrElse(color, color))
    })

    // Step 4: Apply UDF to DataFrame
    val resultDF = df.withColumn("color_code", replaceColorUDF(col("color")))

    // Step 5: Show the result
    resultDF.show(false)

    // Step 6: Stop Spark Session
    spark.stop()
  }
}
