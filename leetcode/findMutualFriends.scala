package leetcode

import org.apache.spark.sql.functions.{col, collect_list}
import org.apache.spark.sql.{Dataset, SparkSession}
object findMutualFriends extends App {

  val spark = SparkSession.builder().appName("trst").master("local[*]")
    .config("spark.sql.shuffle.partitions", "50")
    .getOrCreate()
  /*

  MUTUAL FRIENDS

   */

  import spark.implicits._

  case class Friendship(user1: String, user2: String)

  val friendshipsDF: Dataset[Friendship] = Seq(Friendship("alice", "bob"),
    Friendship("alice", "charlie"),
    Friendship("bob", "charlie"),
    Friendship("bob", "david"),
    Friendship("charlie", "david") // Adding another friendship for more diverse results
  ).toDS()


  def findMutualFriends(userFriendships: Dataset[Friendship]): Dataset[(String, String, Seq[String])] = {
    // Self-join to find mutual friends without using groupBy or distinct
    val joinedDF = userFriendships.alias("f1")
      .join(userFriendships.alias("f2"), col("f1.user1") === col("f2.user1") && col("f1.user2") === col("f2.user2"))
      .where("f1.user1 < f2.user1")

    // Aggregate to get mutual friends
    val mutualFriendsDS = joinedDF
      .groupBy("f1.user1", "f1.user2")
      .agg(collect_list("f1.user2").as("mutualFriends"))
      .as[(String, String, Seq[String])]

   mutualFriendsDS
  }

  val mutualFriendsDS = findMutualFriends(friendshipsDF)

  // Step 3: Show the result
  mutualFriendsDS.show()
}
