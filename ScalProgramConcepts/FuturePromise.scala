package abiP

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Promise

object FuturePromise extends App {

  val p = Promise[String]
  val q = Promise[String]
  p.future foreach (x => println(s"p succeeded with '$x'"))
  Thread.sleep(1000)
  p success "assigned"
  p.future.isCompleted
  q failure new Exception("not kept")
  q.future.failed foreach (t => println(s"q failed with $t"))
  Thread.sleep(1000)
}
