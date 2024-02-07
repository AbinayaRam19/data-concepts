package abiP

object MemoryConfig extends App{

  import org.apache.spark.{SparkConf, SparkContext}

  // Create a SparkConf and SparkContext
  val conf = new SparkConf().setAppName("PetFoodOrders")

  val spark = new SparkContext(conf)
  spark.setLogLevel("ERROR")
  // Create an RDD of pet food orders
  val ordersRDD = spark.parallelize(Seq(
    ("cat food", 5),
    ("dog food", 10),
    ("bird food", 2),
    ("fish food", 3)
  ))

  // Cache the RDD in Off-Heap memory for faster access later
  ordersRDD.checkpoint()

  // Print the total number of orders
  println(s"Total orders: ${ordersRDD.count()}")

  // Map the RDD to a new RDD with prices included
  val pricesRDD = ordersRDD.map { case (food, quantity) => (food, quantity * 2) }

  // Print the total revenue
  println(s"Total revenue: ${pricesRDD.map { case (_, price) => price }.sum()}")

  // Unpersist the RDD from Off-Heap memory
  ordersRDD.unpersist()

  // Collect the data from the RDD into On-Heap memory
  val ordersData = ordersRDD.collect()

  // Print the pet food orders
  println("Pet food orders:")
  ordersData.foreach { case (food, quantity) =>
    println(s"- $food: $quantity")
  }

  // Stop the SparkContext
  spark.stop()

}
