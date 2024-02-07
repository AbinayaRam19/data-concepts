package abiP

import org.apache.spark.sql.SparkSession

object fold {


  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("trst").master("local[*]").getOrCreate()

    val rdd1 = spark.sparkContext.parallelize(List(1, 2, 3, 4))

    println("rdd:" + rdd1.partitions.length)

    val checkZip  = Seq('a','b').zip(Set(1))

    println("check zip  "+checkZip.mkString)
    //3+1+3+2+3+3+3+4+3+5+3

    //3+1 + 3+2  3+3 + 3+4+5  +3

    //3+1  3+2  3+3  3+4 3+5+6 3+7+8 +3


    //    1    = ( 3+1 )+ (3+2)m+(3+3) + (3+4) +3
    //    2
    //    3
    //    4
    //
    //
    //
    //


    var aa = rdd1.fold(3)(_ + _)

    println("fold: " + aa.hashCode())


    val rdd11 = spark.sparkContext.parallelize(List(1, 2, 3, 4, 5), 3)
    var output1 = rdd11.fold(5)(_ + _)
    //OUTPUT: 35

    val rdd2 = spark.sparkContext.parallelize(List(1, 2, 3, 4, 5))
    var output2 = rdd2.fold(5)(_ + _)
    println("output2: " + output2)
    //OUTPUT: 60

    val rdd3 = spark.sparkContext.parallelize(List(1, 2, 3, 4, 5), 3)
    var output3 = rdd3.fold(3)(_ + _)
    //OUTPUT: 27

  }

}
