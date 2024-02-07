package abiP

object JavaCode {
  val maxMarks = 500;
  def calcGrade( total: Int ) : String = {
    if (total >= 60) return "A" else return "B"
  }

    case class Student(id: Int, name: String)
    def getStudentDetails(student: Student)={
      s"$Student.id -- $Student.name"

    }
}
