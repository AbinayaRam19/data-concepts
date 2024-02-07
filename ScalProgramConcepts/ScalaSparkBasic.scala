package abiP
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.{Dataset, SparkSession}

object sparkalaSparkBasic extends  App{
  val spark = SparkSession.builder
    .appName("sparkalaSparkExamples")
    .master("local[*]")
    .getOrCreate()

  val employeeData = Seq(("James", "Sales", 3000),
    ("Michael", "Sales", 4600),
    ("Robert", "Sales", 4100),
    ("Maria", "Finance", 3000),
    ("James", "Sales", 3000),
    ("sparkott", "Finance", 3300),
    ("Jen", "Finance", 3900),
    ("Jeff", "Marketing", 3000),
    ("Kumar", "Marketing", 2000),
    ("Saif", "Sales", 4100),
    ("Bina", "HR", 4000),
    ("Pallavi", "HR", 5000)
  )
  val employeeColumn = Seq("employee_name", "department", "salary")

  //to create RDD
 // val employeeRdd = spark.sparkContext.parallelize(employeeData)


  val employeeDf = spark.createDataFrame(employeeData).toDF(employeeColumn: _*)
  employeeDf.show()

  //to create DS
  import spark.implicits._
  case class Employee(employee_name: String, department: String, salary: Int)
  val employeeDataset: Dataset[Employee] = employeeData.map {
    case (name, department, salary) => Employee(name, department, salary)
  }.toDS()
  employeeDataset.show()


  //Higher order function

  def numbers(nums: List[Int], f:Int => Int)={
    nums.map(f)
  }
  def square(num: Int) = {
    num * num
  }
  numbers(List(4,5,6), square)


  //currying function

  def add(n: Int)(m:Int) ={
    n + m
  }
  var resultn = add(5)(_)
  var finalResult = resultn(4)

  println("currying fun result "+finalResult)


  //partial function
  val even : PartialFunction[Int, Boolean] = {
   case x if x % 2 == 0 => true  }

  println("is par func defined : "+even.isDefinedAt(5))

}
