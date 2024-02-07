package abiP
import SparkWithEMR.SparkSessionWrapper
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

import java.time.{Duration, Instant}

object InfyTest extends  App with SparkSessionWrapper{

  val start_time = Instant.now

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
  val employeeRdd = spark.sparkContext.parallelize(employeeData)
  val employeeDf = spark.createDataFrame(employeeRdd).toDF(employeeColumn: _*)

  val departmentData = Seq(("Sales", "Add_Sales", 30),
    ("Finance", "Add_Finance", 40),
    ("Marketing", "Add_Marketing", 50),
    ("HR", "Add_HR", 50)
  )
  val departmentColumn = Seq("department", "department_address", "building_no")
  val departmentRdd = spark.sparkContext.parallelize(departmentData)
  val departmentDf = spark.createDataFrame(departmentRdd).toDF(departmentColumn: _*)

/*
  -- Employee whose salary is lowest
  -- Employee counts department wise.
    -- Department wise top 2 salaried employees.
    -- Employees working in building 50
*/

  employeeDf.orderBy("salary").limit(1).show()

   employeeDf.groupBy("department").count()

  val windowSpec = Window.partitionBy("department").orderBy(col("salary"))

   employeeDf.withColumn("rank", row_number().over(windowSpec))
    .filter("rank <= 2").drop("rank").show()

 employeeDf.join(departmentDf, "department")
    .filter("building_no = 50").select("employee_name", "department", "salary")
    .show()

  employeeDf.groupBy("department").sum("salary").show()

  println("Duration between "+Duration.between(start_time, Instant.now()).toMillis)
}
