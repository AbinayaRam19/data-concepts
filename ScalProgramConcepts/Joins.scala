package abiP

import org.apache.spark.RangePartitioner
import org.apache.spark.sql.SparkSession

object Joins {


  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("trst").master("local[*]")
      .config("spark.sql.shuffle.partitions", "50")
      .getOrCreate()


    val frdd1 = spark.sparkContext.parallelize(Seq(("Spark", 35), ("Hive", 23), ("Spark", 45), ("HBase", 89)))
    val frdd2 = spark.sparkContext.parallelize(Seq(("Spark", 35), ("Flume", 12), ("Hive", 14), ("Kafka", 25), ("Kafka", 89)))
    val fullouterjoinrdd1 = frdd1.fullOuterJoin(frdd2).persist()
    println("full outer :" + fullouterjoinrdd1.collect.foreach(println))

    println("except " + frdd1.subtract(frdd2).collect().foreach(println))
    /*
    output:
    (Hive,(Some(23),Some(14)))
    (HBase,(Some(89),None))
    (Spark,(Some(35),Some(74)))
    (Spark,(Some(45),Some(74)))
    (Kafka,(None,Some(25)))
    (Kafka,(None,Some(89)))
    (Flume,(None,Some(12)))


     */


    val frdd3 = spark.sparkContext.parallelize(Seq(("Spark", 35), ("Hive", 23), ("Spark", 45), ("HBase", 89)))
    val frdd4 = spark.sparkContext.parallelize(Seq(("Spark", 74), ("Flume", 12), ("Hive", 14), ("Kafka", 25), ("Kafka", 89)))
    val cogroup = frdd3.cogroup(frdd4)
    println("co group :" + cogroup.collect.foreach(println))

    /*
    output:

(Hive,(CompactBuffe--+






r(23),CompactBuffer(14)))
(HBase,(CompactBuffer(89),CompactBuffer()))
(Spark,(CompactBuffer(35, 45),CompactBuffer(74)))
(Kafka,(CompactBuffer(),CompactBuffer(25, 89)))
(Flume,(CompactBuffer(),CompactBuffer(12)))

     */


    val frdd5 = spark.sparkContext.parallelize(Seq(("Spark", 35), ("Hive", 23), ("Spark", 45), ("HBase", 89)))
    val frdd6 = spark.sparkContext.parallelize(Seq(("Spark", 74), ("Flume", 12), ("Hive", 14), ("Kafka", 25), ("Kafka", 89)))
    val leftOuter = frdd5.leftOuterJoin(frdd6)
    println("left outer :" + leftOuter.collect.foreach(println))
    /*
    (Hive,(23,Some(14)))
    (HBase,(89,None))
    (Spark,(35,Some(74)))
    (Spark,(45,Some(74)))
     */


    val frdd7 = spark.sparkContext.parallelize(Seq(("Spark", 35), ("Hive", 23), ("Spark", 45), ("HBase", 89)))
    val frdd8 = spark.sparkContext.parallelize(Seq(("Spark", 74), ("Flume", 12), ("Hive", 14), ("Kafka", 25), ("Kafka", 89)))
    val rightOuter = frdd7.rightOuterJoin(frdd8)
    println("right outer :" + rightOuter.collect.foreach(println))

    /*
    output:
    (Hive,(Some(23),14))
(Spark,(Some(35),74))
(Spark,(Some(45),74))
(Kafka,(None,25))
(Kafka,(None,89))
(Flume,(None,12))

     */


    val frdd9 = spark.sparkContext.parallelize(Seq(("Spark", 35), ("Hive", 23), ("Spark", 45), ("HBase", 89)))
    val frdd10 = spark.sparkContext.parallelize(Seq(("Spark", 74), ("Flume", 12), ("Hive", 14), ("Kafka", 25), ("Kafka", 89)))
    var join = frdd9.join(frdd10)

    println("get number of partitions " + join.getNumPartitions)

    join = join.coalesce(10)

    println("get num of partition after coalesparke " + join.getNumPartitions)

    val sortedReviewsRDD = join.repartitionAndSortWithinPartitions(new RangePartitioner(10, join))

    // Access top-rated products in each partition
    sortedReviewsRDD.take(10).foreach { case (product, mark) =>
      println(s"Partition sortedReviewsRDD " + product + "  " + mark)
    }

    println("join :" + join.collect.foreach(println))
    println("countBy value: " + frdd9.countByValue())
    println("count by key: " + frdd9.countByKey())
    println("reduce by key: " + frdd9.reduceByKey((a, b) => a + b).collect().foreach(println))
    //println("aggregate by key: "+frdd9.aggregateByKey((a,b)=> a+b))
    /*
    OUtput:
    (Hive,(23,14))
    (Spark,(35,74))
    (Spark,(45,74))

    countBy value: Map((Hive,23) -> 1, (Spark,35) -> 1, (Spark,45) -> 1, (HBase,89) -> 1)
    count by key: Map(Hive -> 1, HBase -> 1, Spark -> 2)


     */


    val myrdd1 = spark.sparkContext.parallelize(List(5, 7, 9, 13, 51, 89, 56, 7))
    println("top result: " + myrdd1.top(3).foreach(println))
    println("take orderred: " + myrdd1.takeOrdered(3).foreach(println))

    /*
    OUTPUT:
    top : 89,56,51  -- desparkneding orer
    take order : 5,7,7 -- asparkending order
     */

  }
}
