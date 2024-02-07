package abiP

import org.apache.spark.sql.SparkSession

object letterFreq {


  def main(args: Array[String]): Unit = {

    var str = "aabaabccccc"


    var ll = str.map(a => (a, 1))

    val spark = SparkSession.builder().master("local[1]").appName("test").getOrCreate()

    var a = ll.groupBy(_._1).mapValues(a => a.map(x => x._2).sum)

    a.foreach(x => println(x._2 + " " + x._1))
  }


}
