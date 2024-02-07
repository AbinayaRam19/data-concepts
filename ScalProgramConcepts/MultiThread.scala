package abiP

// Scala code for thread creation by extending
// the Thread class
class MyThread extends Thread {
  override def run(): Unit = {
    // Displaying the thread that is running
    println("Thread " + Thread.currentThread().getName +
      " is running.")
  }
}

// Creating object
object MultiThread {
  // Main method
  def main(args: Array[String]): Unit = {
    for (x <- 1 to 5) {
      var th = new MyThread()
      //th.setName(x.toString())
      //th.start()
    }
  }
}
