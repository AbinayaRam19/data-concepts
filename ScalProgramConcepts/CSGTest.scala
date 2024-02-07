package abiP

/*
Q3) You are given a list of tuples like ("a", 1) where the 1st entry represents a website and the 2nd entry represents userid.
Find the simpler websites based on this click trail
i/p :
  arr = [('a', 1), ('a', 3), ('a', 5),
  ('b', 2), ('b', 6),
  ('c', 1), ('c', 2), ('c', 3), ('c', 4), ('c', 5)
  ('d', 4), ('d', 5), ('d', 6), ('d', 7),
  ('e', 1), ('e', 3), ('e': 5), ('e', 6)]
  k = 1
  o/p: [(a,e)]
 k = 2
  o/p:; [(a,e),(a,c)]
   arr.groupBy(a=> a._1).mapValues(_.map(_._2)).toArray
*/

object CSGTest {

  def main(args: Array[String]): Unit = {

    var arr = List(('a', 1), ('a', 3), ('a', 5), ('b', 2), ('b', 6), ('c', 1),
      ('c', 2), ('c', 3), ('c', 4), ('c', 5), ('d', 4), ('d', 5), ('d', 6),
      ('d', 7), ('e', 1), ('e', 3), ('e', 5), ('e', 6))


    var tempMap: Array[(Char, List[Int])] = arr.groupBy(a => a._1).mapValues(_.map(_._2)).toArray

    println(tempMap.mkString("Array(", ", ", ")"))

  }
}