package abiP

object Multiple {
  def main(args: Array[String]): Unit = {
    trait A {
      var length: Int = _
      def action = {
        length = length + 5
      }
    }
    trait B {
      var height: Int = _
      def action = {
        height = height + 1
      }
    }

    class C extends A with B {
      length = 3;
      height = height + 6;
      override def
      action = {
        super[A].action
        super[B].action
      }

    }
    val c = new C
    c.action
    println(c.height)
    println(c.length)
  }
}
