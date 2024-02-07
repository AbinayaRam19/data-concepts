package abiP

import org.apache.spark.sql.SparkSession;


object wordCountDF {
  def main(args: Array[String]): Unit = {


    val str = List("my name is abinaya is my name")


    val spark = SparkSession.builder().appName("trst").master("local[*]").getOrCreate()

    import spark.implicits._


    //    var a = str.split(" ").groupBy(a => a)
    //
    //    var l1= List("anc", "ahg", "tyhee","ahg", "anc")
    //    var b = l1.groupBy(x => x).mapValues(a => a.size)
    //
    //    println("a: "+b)


    var aa = spark.sparkContext.parallelize(str)

    var res = aa.flatMap(a => a.split(" ")).map(b => (b, 1)).reduceByKey((a, b) => a + b)

    val wordCount = str
      .flatMap(sentence => sentence.split(" ")) // Split each sentence into words
      .map(word => (word.toLowerCase, 1)) // Convert each word to lowercase and create a tuple with count 1
      .groupBy(_._1)// Group words by lowercase
      .map { case (word, occurrences) => (word, occurrences.length) } // Count occurrences for each word


    println("get num1: "+res.getNumPartitions)
    res = res.coalesce(18);

    println("get num2: "+res.getNumPartitions)

    res.collect().foreach(println)


  }
}

