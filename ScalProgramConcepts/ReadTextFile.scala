package abiP
import org.apache.spark.sql.SparkSession


object ReadTextFile extends App {

  val spark = SparkSession.builder().appName("trst").master("local[*]").getOrCreate()

  val distFile = spark.sparkContext.textFile("E:\\Abi\\sample.txt")

  distFile.collect().mkString(",")

}
