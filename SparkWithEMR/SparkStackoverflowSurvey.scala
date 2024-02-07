package SparkWithEMR

import org.apache.spark.sql.SparkSession

object SparkStackoverflowSurvey extends App {

  // Create a Spark session
  val spark = SparkSession.builder.appName("StackoverflowSurvey").master("local[*]")
    .config("spark.hadoop.fs.s3a.access.key", "<key>")
    .config("spark.hadoop.fs.s3a.secret.key", "<secret_key>")
    .config("spark.hadoop.fs.s3a.endpoint", "s3.us-east-2.amazonaws.com")
    .getOrCreate()


  // Read data from S3
  val responses = spark.read
    .option("header", "true")
    .option("inferSchema", value = true)
    .csv("s3a://sotestbucket/survey_results.csv")


  // Print the schema
  println("Schema of the dataset:")
  responses.printSchema()

  // Show selected columns
  responses.select("Country", "CodingActivities").show()

  // Stop the Spark session
  spark.stop()
}
